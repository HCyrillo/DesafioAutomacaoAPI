package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import utils.BaseUtils;

import static org.junit.Assert.assertEquals;

public class ClienteElegivelSteps extends BaseUtils {
	private String indicadorElegibilidadeCliente;
	private String clienteCorrentista;
	private String contaAtiva;
	private String tipoProduto;
	private int codigoProdutoOrigem;
	private String body;

	@Given("que o indicador cliente correntista é {string}")
	public void indicadorClienteCorrentista(String indicador) {
		try {
			if (indicador != null && indicador != "") {
				setClienteCorrentista(indicador);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("que o indicador conta ativa é {string}")
	public void indicadorContaAtiva(String indicador) {
		try {
			if (indicador != null && indicador != "") {
				setContaAtiva(indicador);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("que o código tipo produto oferta é {string}")
	public void codigoTipoProdutoOferta(String codigo) {
		try {
			if (codigo != null && codigo != "") {
				setTipoProduto(codigo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("o código produto origem é {int}")
	public void codigoProdutoOrigem(int codigo) {
		try {
			if (codigo != 0) {
				setCodigoProdutoOrigem(codigo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("eu verifico a elegibilidade do cliente")
	public void verificarElegibilidadeCliente() {
		body = "{\"eligibilidade_cliente_entrada\": {\"contratos\": " + "[{\"indicador_conta_ativa\": \"" + contaAtiva
				+ "\", \"indicador_cliente_correntista\": \"" + clienteCorrentista
				+ "\", \"codigo_tipo_produto_oferta\": \"" + tipoProduto + "\", \"codigo_produto_origem\": "
				+ codigoProdutoOrigem + "}]}}";

		response = RestAssured.given().contentType(contentType).accept(accept).body(body)
				.post(endpointURL);

		indicadorElegibilidadeCliente = response.jsonPath().get("indicador_elegibilidade_cliente");
	}

	@Then("o indicador de elegibilidade do cliente deve ser {string}")
	public void indicadorElegibilidadeCliente(String indicadorEsperado) {
		assertEquals(indicadorEsperado, indicadorElegibilidadeCliente);
		// Caso exisitisse o statusCode esperado, poderia validar nesta parte o mesmo
	}

	public String getClienteCorrentista() {
		return clienteCorrentista;
	}

	public void setClienteCorrentista(String clienteCorrentista) {
		this.clienteCorrentista = clienteCorrentista;
	}

	public String getContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(String contaAtiva) {
		this.contaAtiva = contaAtiva;
	}

	public int getCodigoProdutoOrigem() {
		return codigoProdutoOrigem;
	}

	public void setCodigoProdutoOrigem(int codigoProdutoOrigem) {
		this.codigoProdutoOrigem = codigoProdutoOrigem;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
}
