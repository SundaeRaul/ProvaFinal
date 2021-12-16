import Principal from './Pages/Principal';
import CriaProduto from './Pages/CriaProduto';
import { Routes, Route } from 'react-router-dom';

function Rotas() {

    return(
        <Routes>
            <Route path="/" element={<Principal />} exact />
            <Route path="criar-produto" element={<CriaProduto />} />
        </Routes>
    )

}

export default Rotas;