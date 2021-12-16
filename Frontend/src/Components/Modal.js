import axios from 'axios';
import React, { useCallback } from 'react';
import { useEffect, useState } from 'react/cjs/react.development';
import styled from 'styled-components';
import api from '../api';

const ModalWrapper = styled.div`
    width: 30%;
    height: 70%;
    position: absolute;
    left: 35%;
    top: 2%;
    box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;

    p {
        position: absolute;
        background-color: transparent;
        font-size: 35px;
        right: 5px;
        top: 5px;
        cursor: pointer
    }

    form{
        width: 100%;
        height: 100%;
        display: flex;
        flex-flow: column;
        align-items: center;
        justify-content: center;

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

        select {
            width: 60%;
            margin-top: 2%;
            padding: 2%;
            outline: none;
            border: 1px solid transparent;
            background-color: #C1C1C1;
            border-radius: 5px;
        }

        select:focus{
            border: 1px solid #0B3B86;
        }
    }
`;

function Modal({id}) {

    useEffect(() => {
        async function BuscaProduto() {
            const response = await api.get(`produtos/${id}`)
            setProduto(response.data);
        }
        if(id) {
            BuscaProduto();
        }
    }, [id]);

    console.log(id);

    const [showModal, SetShowModal] = useState(true);

    const [produto, setProduto] = useState([]);

    const [nome, setNome] = useState("");

    const [fornecedor, setFornecedor] = useState("");

    const [qtt, setQtt] = useState();

    const [precoCompra, setPrecoCompra] = useState();

    const [precoVenda, setPrecoVenda] = useState();

    const [tipo, setTipo] = useState([]);

    const [estoque, setEstoque] = useState([]);

    function handleSubmit(event) {
        const ctt = {
            nome: nome,
            fornecedor: fornecedor,
            quantidade: qtt,
            precoCompra: precoCompra,
            precoVenda: precoVenda,
            TipoProduto: {
                nome: tipo
            },
            Estoque: {
                nome: estoque
            }
        }

        axios.put(`http://localhost:8080/produtos/${id}`, ctt)
        .then(
            window.location.reload()
        )
    }


    return(
        <ModalWrapper style={{display: showModal? 'flex' : 'none'}}>
            <p onClick={() => SetShowModal(!showModal)}>X</p>
            <form onSubmit={handleSubmit}>
                <h3>Editar produto</h3>
                <input placeholder="Nome" name='nome' type={'text'} onChange={(e) => setNome(e.target.value)}/>
                <input placeholder="Fornecedor" name='fornecedor' type={'text'} onChange={(e) => setFornecedor(e.target.value)}/>
                <input placeholder="Quantidade" name='quantidade' type={'number'} onChange={(e) => setQtt(e.target.value)}/>
                <input placeholder="Valor de Compra" name='preco Compra' type={'number'} onChange={(e) => setPrecoCompra(e.target.value)}/>
                <input placeholder="Valor de venda" name='PrecoCompra' type={'number'} onChange={(e) => setPrecoVenda(e.target.value)}/>
                <button type='submit'>Alterar</button>
            </form>
        </ModalWrapper>
    )
}
    export default Modal;