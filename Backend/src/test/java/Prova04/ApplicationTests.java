package Prova04;

import Prova04.Model.Produtos;
import Prova04.Model.TipoProduto;
import Prova04.Repository.ProdutosRepository;
import Prova04.Repository.TipoProdutoRepository;
import Prova04.util.EstoqueCreator;
import Prova04.util.ProdutosCreator;
import Prova04.util.TipoProdutoCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private ProdutosRepository prep;

	@Autowired
	private TipoProdutoRepository trep;

	@Test
	void criaProdutoInvalido_deveRetornarErro() {
		Produtos produto =  new Produtos(1L, null, "Tagima", 1, 750.00, 800.00, TipoProdutoCreator.createTipoProduto(), EstoqueCreator.createEstoque());

		ResponseEntity<Produtos> resp = this.testRestTemplate
				.postForEntity("http://localhost:" + port + "/produtos", produto, Produtos.class);

		Assertions.assertThat(resp.getBody().getNome()).isNull();
		Assertions.assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Test
	void tentaCriarProdutoEtipoProduto_deveRetornarHttpStatusUnauthorized() {
		Produtos produto = ProdutosCreator.createValidProduct();
		TipoProduto expectedTipoProduto = TipoProdutoCreator.createTipoProduto();

		ResponseEntity<Produtos> resp = this.testRestTemplate
						.postForEntity("http://localhost:" + port + "/produtos", produto, Produtos.class);
		ResponseEntity<TipoProduto> respT = this.testRestTemplate
						.postForEntity("http://localhost:" + port + "/tipoproduto", expectedTipoProduto, TipoProduto.class);

		Assertions.assertThat(resp).isNotNull();
		Assertions.assertThat(respT).isNotNull();
		Assertions.assertThat(resp.getBody().getTipoproduto().getNome()).isEqualTo(respT.getBody().getNome());
	}

}
