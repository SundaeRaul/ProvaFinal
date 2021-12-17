import axios from 'axios';

const apiGetter = () => {
    axios
    .get("https://localhost:8080/produtos")
    .then((res) => res.data.nome)
    .catch((err) => console.log(err))
}

export default apiGetter;