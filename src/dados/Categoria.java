package dados;

public enum Categoria {

	ACA("Acao",0.90),
	DRA("Drama",0.70),
	FIC("Ficcao",0.50),
	ROM("Romance",0.30);

	private String nome;
	private double valor;

	private Categoria(String nome,double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}
	public double getValor(){
		return valor;
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

