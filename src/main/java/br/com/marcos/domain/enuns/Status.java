package br.com.marcos.domain.enuns;

public enum Status {

	ABERTO(0, "ABERTO"), ADAMENTO(1, "ADAMENTO"), ENCERRADO(2, "ENCERRADO");

	private Integer cod;
	private String descricao;

	private Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Status toEnun(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (Status x : Status.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade inválida! " + cod);
	}
}
