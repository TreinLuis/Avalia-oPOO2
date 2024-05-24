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
        if (consultaCodigo(midia.getCodigo()) != null) {
            return false;
        }
        return listaMidias.add(midia);
    }

    public Midia consultaCodigo(int codigo) {
        for (Midia m : listaMidias) {
            if (m.getCodigo() == codigo) {
                return m;
            }
        }
        return null;
    }

    public List<Midia> consultaPorCategoria(Categoria categoria) {
        List<Midia> midias = new ArrayList<>();
        for (Midia m : listaMidias) {
            if (m.getCategoria().equals(categoria)) {
                midias.add(m);
            }
        }
        return midias;
    }

    public <T extends Midia> List<T> consultaGeneralizada(Class<T> tipo, Number number) {
        List<T> result = new ArrayList<>();
        for (Midia m : listaMidias) {
            if (tipo.isInstance(m)) {
                if (m instanceof Video && number.equals(((Video) m).getQualidade())) {
                    result.add(tipo.cast(m));
                } else if (m instanceof Musica && number.equals(((Musica) m).getDuracao())) {
                    result.add(tipo.cast(m));
                }
            }
        }
        return result;
    }
    public Midia midiaMaisNova() {
        Midia midiaMaisNova = listaMidias.get(0);
        for (Midia m : listaMidias) {
            if (m.getAno() > midiaMaisNova.getAno()) {
                midiaMaisNova = m;
            }
        }
        return midiaMaisNova;
    }

    public boolean removeMidia(int codigo) {
        Midia m = consultaCodigo(codigo);
        if (m != null) {
            listaMidias.remove(m);
            return true;
        } else {
            return false;
        }
    }

    public double somatorioLocacoes() {
        double somatorio = 0;
        for (Midia m : listaMidias) {
            somatorio += m.calculaLocacao();
        }
        return somatorio;
    }


    /**
     * @see Iterador#reset()
     */
    public void reset() {
        this.contador = 0;
    }


    /**
     * @see Iterador#hasNext()
     */
    public boolean hasNext() {
        return contador < midia.size();
    }


    /**
     * @see Iterador#next()
     */
    public Object next() {
        if (!hasNext()) {
            throw new IllegalStateException("Não possui elementos!");
        } else {
            return listaMidias.get(contador++);
        }
    }
}
