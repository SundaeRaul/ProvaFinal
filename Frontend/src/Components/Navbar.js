import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

const NavWrapper = styled.div`
    width: 100%;
    background-color: #FF9D30;
    display: flex;
    align-items: center;
    justify-content: space-between;

    .container {
        background-color: #FF9D30;
        display: flex;
        align-items: center;
        justify-content: space-between;

        h2{
            width: 13%;
            text-align: center;
            background-color: #FF9D30;
            color: #0B3B86;
        }

        .navigation{
            width: 20%;
            background-color: #FF9D30;

            a {
                width: 40%;
                padding: 3%;
            }

            button{
                outline: none;
                border: 2px solid #0B3B86;
                border-radius: 10px;
                background: transparent;
                width: 100%;
                height: 100%;
                font-size: 1.2rem;
                font-weight: bold;
                color: #0B3B86;
            }
        }
    }
`;

function Navbar() {
    return(
        <NavWrapper>
            <div className='container'>
                <h2>Vendinha do RAU</h2>
                <div className='navigation d-flex align-items-center justify-content-around'>
                    <Link to="/">
                        <button>Home</button>
                    </Link>
                    <Link to="/criar-produto">
                        <button>Criar Prod.</button>
                    </Link>
                </div>
            </div>
        </NavWrapper>
    )
}

export default Navbar;