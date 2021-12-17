import react, { useCallback } from 'react';
import styled from 'styled-components';
import Navbar from '../Components/Navbar';
import { useState, useEffect } from 'react';
import axios from 'axios';
import api from '../api';


const CriaProdutoWrapper = styled.div`
    width: 100%;
    height: 90vh;
    display: flex;
    align-items: center;
    justify-content: center;

    form {
        width: 40%;
        height: 90%;
        box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;
        display: flex;
        flex-flow: column;
        align-items: center;
        justify-content: center;
        
        h1 {
            margin-top: 10px;
        }

        input {
            width: 60%;
            margin-top: 2%;
            padding: 2%;
            outline: none;
            border: 1px solid transparent;
            background-color: #C1C1C1;
            border-radius: 5px;
        }

        input:focus {
            border: 1px solid #0B3B86;
        }

        button {
            outline: none;
            border: 2px solid #0B3B86;
            padding: .6rem;
            width: 30%;
            margin-top: 3%;
            font-size: 1.2rem;
            font-weight: bold;
        }

        select {
            padding: 1rem;
            width: 60%;
            margin-top: 3%;
        }
    }
`;

function CriaProduto() {

    const [listTipos, SetListTipos] = useState([]);

    const [estoqueList, SetEstoqueList] = useState([]);

    const [nome, setNome] = useState("");

    const [fornecedor, setFornecedor] = useState("");

    const [qtt, setQtt] = useState();

    const [precoCompra, setPrecoCompra] = useState();

    const [precoVenda, setPrecoVenda] = useState();

    const [tipo, setTipo] = useState("");

    const [estoque, setEstoque] = useState("");

    function handleSubmit(){

        const ctt = {
            nome: nome,
            fornecedor: fornecedor,
            quantidade: qtt,
            precoCompra: precoCompra,
            precoVenda: precoVenda,
            tipoProduto: {
                nome: tipo
            },
            estoque_id: {
                nome: estoque,
            }
        }

        api.post('/produtos', ctt)
    }


    return(
        <>
            <Navbar />
            <CriaProdutoWrapper>
                <form onSubmit={handleSubmit}>
                    <h1>Criar Produto</h1>
                    <input placeholder="Nome" name='nome' type={'text'} onChange={(e) => setNome(e.target.value)}/>
                    <input placeholder="Fornecedor" name='fornecedor' type={'text'} onChange={(e) => setFornecedor(e.target.value)}/>
                    <input placeholder="Quantidade" name='quantidade' type={'number'} onChange={(e) => setQtt(e.target.value)}/>
                    <input placeholder="Valor de Compra" name='preco Compra' type={'number'} onChange={(e) => setPrecoCompra(e.target.value)}/>
                    <input placeholder="Valor de venda" name='PrecoCompra' type={'number'} onChange={(e) => setPrecoVenda(e.target.value)}/>
                    <input placeholder="Tipo de produto" name='preco Compra' type={'text'} onChange={(e) => setTipo(e.target.value)}/>
                    <input placeholder="Estoque" name='PrecoCompra' type={'text'} onChange={(e) => setEstoque(e.target.value)}/>
                    <button type='submit'>Criar</button>
                </form>
            </CriaProdutoWrapper>
        </>
    )
}

export default CriaProduto;