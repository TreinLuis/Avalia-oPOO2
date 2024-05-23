package dados;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class Midiateca implements Iterador {

	private int contador;
	private List<Midia> listaMidias;

	private Collection<Midia> midia;

	public Midiateca() {
 		listaMidias= new ArrayList<>();
	}

	public boolean cadastraMidia(Midia midia) {
		if(consultaPorCodigo(midia.getCodigo()) != null){
			return false;
		}
		return listaMidias.add(midia);
	}
	public Midia consultaPorCodigo(int codigo) {
		for(Midia m : listaMidias){
			if(m.getCodigo() == codigo){
				return m;
			}
		}
		return null;
	}

	public ArrayList<Midia> consultaPorCategoria(Categoria categoria) {

		return null;
	}

	public boolean removeMidia(int codigo) {
		return false;
	}


	/**
	 * @see dados.Iterador#reset()
	 */
	public void reset() {

	}


	/**
	 * @see dados.Iterador#hasNext()
	 */
	public boolean hasNext() {
		return false;
	}


	/**
	 * @see dados.Iterador#next()
	 */
	public Object next() {
		return null;
	}

}
