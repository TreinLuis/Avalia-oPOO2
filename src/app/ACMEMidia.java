package app;

import dados.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ACMEMidia {
    private PrintStream saidaPadrao = System.out;
    private  String nomeArquivoEntrada = "entrada (2).txt";
    private  String nomeArquivoSaida = "dadosout.txt";
    private Scanner in = new Scanner(System.in);

    private Midiateca midiateca;

    public ACMEMidia() {
        midiateca = new Midiateca();
        redirecionaES();
    }

    public void executa() {
        cadastraVideo();//Done
        cadastraMusica();//Done
        exibeDadosMidia();//Done
        exibeDadosCategoria();//Done
        exibeDadosQualidade();//Done
        //exibeDadosDuracao();//Done
        removeMidia();//Done
        somatorioLocacoes();//Done
        exibeDadosMusicaLocacaoMedia();//
        exibeDadosMidiaNova();//
    }
    public void cadastraVideo() {
        var codigo = in.nextInt();
        in.nextLine();

        while (codigo != -1) {
            String titulo = in.nextLine();

            int ano = in.nextInt();
            in.nextLine();

            Categoria categoria = categoria();

            int qualidade = in.nextInt();

            Video v = new Video(codigo, titulo, ano, categoria, qualidade);
            if (!midiateca.cadastraMidia(v)) {
                System.out.println(" 1:Erro-video com codigo repetido: " + codigo);
            } else {
                System.out.println("1:" + codigo + "," + titulo + "," +
                        ano + "," + categoria.getNome() + "," + qualidade);
            }
            codigo = in.nextInt();
            in.nextLine();

        }

    }

    public void cadastraMusica() {
        var codigo = in.nextInt();
        in.nextLine();

        while (codigo != -1) {

            String titulo = in.nextLine();

            int ano = in.nextInt();
            in.nextLine();

            Categoria categoria = categoria();

            double duracao = in.nextDouble();
            in.nextLine();

            Musica m = new Musica(codigo, titulo, ano, categoria, duracao);
            if (!midiateca.cadastraMidia(m)) {
                System.out.println(" 2:Erro-musica com codigo repetido: " + codigo);
            } else {
                System.out.println("2:" + codigo + "," + titulo + "," +
                        ano + "," + categoria.getNome() + "," + duracao);
            }
            codigo = in.nextInt();
            in.nextLine();
        }
    }

    public void exibeDadosMidia() {
        Midia m;
        int codigo = in.nextInt();
        in.nextLine();
        m = midiateca.consultaCodigo(codigo);
        if (m != null) {
            System.out.println("3:" + m.toString());
        } else {
            System.out.println("3:codigo inexistente.");
        }

    }

    public void exibeDadosCategoria() {
        List<Midia> midiasCategoria;

        Categoria categoria = categoria();
        midiasCategoria = midiateca.consultaPorCategoria(categoria);
        if (midiasCategoria.isEmpty()) {
            System.out.println("4:Nenhuma midia encontrada.");
        } else {
            for (Midia m : midiasCategoria) {
                if (m instanceof Video) {
                    Video video = (Video) m;
                    System.out.println("4:"+  video.toString());
                } else if (m instanceof Musica) {
                    Musica musica = (Musica) m;
                    System.out.println("4:"+musica.toString());
                }
            }
        }
    }

    public void exibeDadosQualidade() {
        List<Midia> midiasQualidade;

        int qualidade = in.nextInt();
        in.nextLine();
        midiasQualidade = midiateca.consultaGeneralizada(Midia.class, qualidade);
        if (midiasQualidade.isEmpty()) {
            System.out.println("5:Qualidade inexistente.");
        } else {
            for (Midia m : midiasQualidade) {
                System.out.println("5:"+m.toString());
            }
        }
    }

    public void exibeDadosDuracao() {
        List<Midia> midiasDuracao;

        double duracao = in.nextDouble();
        System.out.println(duracao);
        //in.nextLine();
        midiasDuracao = midiateca.consultaGeneralizada(Midia.class, duracao);
        if (midiasDuracao.isEmpty()) {
            System.out.println("6:Nenhuma música encontrada.");
        } else {
            for (Midia m : midiasDuracao) {
                System.out.println("6:" + m.toString());
            }
        }
    }

    public void removeMidia() {
        int codigo = in.nextInt();
        in.nextLine();
        Midia m = midiateca.consultaCodigo(codigo);

        if(m!=null){
            System.out.println("7:" + m.toString());
            midiateca.removeMidia(codigo);
        } else {
            System.out.println("7:codigo inexistente.");

        }
    }

    public void somatorioLocacoes() {
        double somatorio = midiateca.somatorioLocacoes();
        if(somatorio == 0.0){
            System.out.println("8:Nenhuma mídia encontrada.");
        } else{
            System.out.println("8:"+ somatorio);
        }
    }

    public void exibeDadosMusicaLocacaoMedia() {
        try {
            Musica musicaMaisProximaDaMedia = (Musica) midiateca.musicaMaisProximoMedia();
            if (musicaMaisProximaDaMedia == null) {
                System.out.println("9:Nenhuma música encontrada.");
            } else {
                System.out.println("9:" + musicaMaisProximaDaMedia.getCodigo() + "," +
                        musicaMaisProximaDaMedia.getTitulo() + "," +
                        musicaMaisProximaDaMedia.getAno());
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao obter a música mais próxima da média: " + e.getMessage());
        }
    }

    public void exibeDadosMidiaNova() {
        try {
            Midia maisNova = midiateca.midiaMaisNova();
            if (maisNova != null) {
                System.out.println("10:"+ maisNova.toString() );
            } else {
                System.out.println("10: Nenhuma mídia encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao obter a mídia mais nova: " + e.getMessage());
        }
    }

    public Categoria categoria() {
        //System.out.println("Digite a categoria: ");
        String categoriaStr = in.nextLine();

        Categoria categoria;
        try {
            categoria = Categoria.fromString(categoriaStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Categoria inválida!");
            return null;
        }
        return categoria;
    }

    private void redirecionaES() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            in = new Scanner(streamEntrada);
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);
        in.useLocale(Locale.ENGLISH);
    }

    private void restauraES() {
        System.setOut(saidaPadrao);
        in = new Scanner(System.in);
    }
}