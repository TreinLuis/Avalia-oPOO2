package dados;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class Midiateca implements Iterador {

    private int contador;
    private List<Midia> listaMidias;

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
    public Midia maiorDuracao() {
        Musica maior = null;
        for (Midia m : listaMidias) {
            if (m instanceof Musica) {
                Musica musica = (Musica) m;
                if (maior == null || maior.getDuracao() < musica.getDuracao()) {
                    maior = musica;
                }
            }
        }
        return maior;
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

    public Midia musicaMaisProximoMedia(){
        List<Musica> musicas = new ArrayList<>();
        for (Midia m : listaMidias) {
            if (m instanceof Musica) {
                musicas.add((Musica) m);
            }
        }
        double soma = 0;
        for (Musica musica : musicas) {
            soma += musica.calculaLocacao();
        }
        double media = soma / musicas.size();
        Musica musicaMaisProximaDaMedia = musicas.get(0);
        double menorDiferenca = Math.abs(musicaMaisProximaDaMedia.calculaLocacao() - media);
        for (Musica musica : musicas) {
            double diferenca = Math.abs(musica.calculaLocacao() - media);
            if (diferenca < menorDiferenca) {
                musicaMaisProximaDaMedia = musica;
                menorDiferenca = diferenca;
            }
        }
        return musicaMaisProximaDaMedia;
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
        return contador < listaMidias.size();
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
