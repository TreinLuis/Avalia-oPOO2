package dados;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class Midiateca implements Iterador {

    private int contador;
    private List<Midia> listaMidias;

    private Collection<Midia> midia;

    public Midiateca() {
        this.contador = 0;
        listaMidias = new ArrayList<>();
    }

    public boolean cadastraMidia(Midia midia) {
        if (consultaPorCodigo(midia.getCodigo()) != null) {
            return false;
        }
        return listaMidias.add(midia);
    }

    public Midia consultaPorCodigo(int codigo) {
        for (Midia m : listaMidias) {
            if (m.getCodigo() == codigo) {
                return m;
            }
        }
        return null;
    }

    public List<Midia> consultaPorCategoria(Categoria categoria) {
		List<Midia> midias = new ArrayList<>();
		for(Midia m : listaMidias){
			if(m.getCategoria().equals(categoria)){
				midias.add(m);
			}
		}
        return midias;
    }
	public List<Midia> consultaPorQualidade(int qualidade){
		List<Midia> videos = new ArrayList<>();
		for(Midia m : listaMidias){
			if(m instanceof Video){
				Video video = (Video) m;
				if(video.getQualidade() == qualidade){
					videos.add(video);
				}
			}
		}
		return videos;
	}

    public boolean removeMidia(int codigo) {

        return false;
    }


    /**
     * @see dados.Iterador#reset()
     */
    public void reset() {
        this.contador = 0;
    }


    /**
     * @see dados.Iterador#hasNext()
     */
    public boolean hasNext() {
        return contador < midia.size();
    }


    /**
     * @see dados.Iterador#next()
     */
    public Object next() {
        if (!hasNext()) {
            throw new IllegalStateException("Não possui elementos!");
        } else {
            return listaMidias.get(contador++);
        }
    }
}
