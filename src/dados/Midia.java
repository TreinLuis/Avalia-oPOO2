package dados;

public abstract class Midia {

	private int codigo;

	private String titulo;

	private int ano;

	public Midia(int codigo, String titulo, int ano, Categoria categoria) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.ano = ano;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public abstract double calculaLocacao();

}

