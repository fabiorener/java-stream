package stream;

public enum FormaPagamento {

	CARTAO("Cart�o"),
	DINHEIRO("Dinheiro");

	private String descricao;

	FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
