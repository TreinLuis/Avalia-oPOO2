package dados;

public class Video extends Midia {

	private int qualidade;

	public Video(int codigo, String titulo, int ano, Categoria categoria, int qualidade) {
        super(codigo,titulo,ano,categoria);
		this.qualidade = qualidade;

    }

	public int getQualidade() {
		return qualidade;
	}

	public void setQualidade(int qualidade) {
		this.qualidade = qualidade;
	}

	@Override
	public double calculaLocacao() {
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + " | Qualidade: " + qualidade + "p" +
				" | Locação: "+ calculaLocacao() + " Reais." ;
	}
}
