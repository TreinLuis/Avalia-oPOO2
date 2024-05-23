package dados;

public enum Categoria {

	ACA("Acao"),
	DRA("Drama"),
	FIC("Ficcao"),
	ROM("Romance");

	private String nome;

	private Categoria(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static Categoria fromString(String nome) {
		for (Categoria categoria : Categoria.values()) {
			if (categoria.getNome().toUpperCase().contains(nome.toUpperCase())) {
				return categoria;
			}
		}
		throw new IllegalArgumentException("Categoria não encontrada: " + nome);
	}
}

