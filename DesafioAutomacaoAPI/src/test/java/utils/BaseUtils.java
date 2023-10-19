package utils;

import io.restassured.response.Response;

public class BaseUtils {
	public Response response;
	public String endpointURL = "https://teste/1.0/elegibilidade_cliente";
	public String indicadorElegibilidadeCliente;
	public String clienteCorrentista;
	public String contaAtiva;
	public String tipoProduto;
	public int codigoProdutoOrigem;
	public String body;
	public String contentType = "application/json";
	public String accept = "application/json";
}
