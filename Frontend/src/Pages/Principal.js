import React from 'react';
import Navbar from '../Components/Navbar';
import api from '../api';
import styled from 'styled-components';
import { useEffect, useState } from 'react';
import Modal from '../Components/Modal';


const TabelaItens = styled.div`
    width: 95%;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;

    .single-item{
        display: flex;
        align-items: center;
        justify-content: space-around;
        text-align: center;
        margin-bottom: 5%;

        h4{
            width: 16%;
        }

        .botoes{
            width: 10%;

            .edit{
                padding: .5rem;
                border: none;
                outline: none;
                background: #5C42EE;
                color: white;
                margin-right: 2px;
            }
            .exclude{
                padding: .5rem;
                border: none;
                outline: none;
                background: #FF6B4C;
                color: white;
                margin-left: 2px;
            }
        }
    }

    .single-item:first-child{
        margin-top: 2%;
    }

    .single-item:last-child{
        margin-bottom: 2%;
    }

`;

function Principal() {

    const [produtos, SetProdutos] = useState([]);
    const [showModal, SetShowModal] = useState(false);
    const [prodId, setProdId] = useState(null);

    useEffect(() => {
        async function ListaProdutos() {
            const response = await api.get('/produtos')
            console.log(response);
            SetProdutos(response.data);
        }
        ListaProdutos();
    }, [])

    async function deletaProduto() {
        const resp = await api.delete(`produtos/${prodId}`)
    }

    console.log(produtos);
    console.log(prodId);

    return(
        <div>
            <Navbar />
            <div className='container mt-5 d-flex align-items-center flex-column justify-content-center'>
                <h2>Produtos</h2>
                <TabelaItens>
                    {produtos.map(prod =>
                    <div className='single-item' key={prod.produtoId}>
                        <h4>{prod.nome}</h4>
                        <span><b>Fornecedor</b><br></br>{prod.fornecedor}</span>
                        <span><b>Quantidade</b><br></br>{prod.quantidade}</span>
                        <span><b>Preço de Compra</b><br></br>{prod.precoCompra}</span>
                        <span><b>Preço de Venda</b><br></br>{prod.precoVenda}</span>
                        <span><b>Tipo</b><br></br>{prod.tipoproduto.nome}</span>
                        <span><b>Estoque</b><br></br>{prod.estoque_id.nome}</span>
                        <div className='botoes'>
                            <button className='edit' onClick={() => {
                                setProdId(prod.produtoId);
                                SetShowModal(!showModal)
                            }}>Editar</button>
                            <button className='exclude' onClick={() =>{ 
                                setProdId(prod.produtoId);
                                deletaProduto()
                                }}>Excluir</button>
                        </div>
                    </div>    
                    )}
                    { showModal && (
                        <Modal id={prodId&&prodId} />
                    )}
                </TabelaItens>
            </div>
        </div>
    )
}

export default Principal;