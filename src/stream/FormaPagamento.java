package stream;

public enum FormaPagamento {

	CARTAO("Cartão"),
	DINHEIRO("Dinheiro");

	private String descricao;

	FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
