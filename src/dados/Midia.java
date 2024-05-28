package dados;

public abstract class Midia {

	private int codigo;

	private String titulo;

	private int ano;
	private Categoria categoria;

	public Midia(int codigo, String titulo, int ano, Categoria categoria) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.ano = ano;
	}
	public Categoria getCategoria(){
		return categoria;
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

	@Override
	public String toString() {
		return   codigo + "," + titulo
				+ "," + getCategoria().getNome();
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public abstract double calculaLocacao();

}

