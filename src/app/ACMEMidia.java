package app;

import dados.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ACMEMidia {
    private Scanner in = new Scanner(System.in);

    private Midiateca midiateca;

    public ACMEMidia() {
        midiateca = new Midiateca();
    }

    public void executa() {
        //cadastraVideo();
        cadastraMusica();
    }

    public void cadastraVideo() {
        var continuar = 0;
        while (continuar != -1) {
            System.out.println("Digite o código do vídeo: ");
            int codigo = in.nextInt();
            in.nextLine();

            System.out.println("Digite o título: ");
            String titulo = in.nextLine();

            System.out.println("Digite a categoria do vídeo: ");
            String categoriaStr = in.nextLine();

            Categoria categoria;
            try {
                categoria = Categoria.fromString(categoriaStr);
                System.out.println(categoria);
            } catch (IllegalArgumentException e) {
                System.out.println("Categoria inválida!");
                return;
            }

            System.out.println("Digite o ano de lançamento do vídeo: ");
            int ano = in.nextInt();
            in.nextLine();

            System.out.println("Digite a qualidade da imagem do vídeo: ");
            int qualidade = in.nextInt();

            Video v = new Video(codigo, titulo, ano, categoria, qualidade);
            if (!midiateca.cadastraMidia(v)) {
                System.out.println(" 1:Erro-video com codigo repetido: " + codigo);
            } else {
                System.out.println("Codigo: " + codigo + " | Título: " + titulo + " | Ano: " +
                        ano + " | Categoria: " + categoria.getNome() + " | Qualidade: " + qualidade + "p.");
            }
            System.out.println("Caso não queira mais adicionar musíca digite -1! ");
            continuar = in.nextInt();
            in.nextLine();
        }

    }

    public void cadastraMusica() {
        var continuar = 0;

        while (continuar != -1) {
            System.out.println("Digite o código da musíca: ");
            int codigo = in.nextInt();
            in.nextLine();
            System.out.println("Digite o título: ");
            String titulo = in.nextLine();

            System.out.println("Digite a categoria da musíca: ");
            String categoriaStr = in.nextLine();

            Categoria categoria;
            try {
                categoria = Categoria.fromString(categoriaStr);
                System.out.println(categoria);
            } catch (IllegalArgumentException e) {
                System.out.println("Categoria inválida!");
                return;
            }

            System.out.println("Digite o ano de lançamento da musíca: ");
            int ano = in.nextInt();
            in.nextLine();

            System.out.println("Digite a duração da musíca: ");
            double duracao = in.nextDouble();
            in.nextLine();

            Musica m = new Musica(codigo, titulo, ano, categoria, duracao);
            if (!midiateca.cadastraMidia(m)) {
                System.out.println(" 1:Erro-musica com codigo repetido: " + codigo);
            } else {
                System.out.println("Codigo: " + codigo + " | Título: " + titulo + " | Ano: " +
                        ano + " | Categoria: " + categoria.getNome() + " | Duração: " + duracao + " min.");
            }
            System.out.println("Caso não queira mais adicionar musíca digite -1! ");
            continuar = in.nextInt();
            in.nextLine();

        }


//: lê o código de uma mídia. Se não
//		existir uma mídia com o código indicado, mostra a mensagem de erro: 3:codigo
//		inexistente.
//				Se existir, mostra os dados da mídia no formato:
//		3:atributo1,atributo2,atributo3,...,valor da locação
    }

    public void exibeDadosMidia() {
//	: lê a categoria de
//		uma mídia. Se não existir uma mídia com a categoria indicada, mostra a mensagem
//		de erro: 4:Nenhuma midia encontrada.
//				Se existir, mostra os dados da(s) mídia(s) no formato:
//		4:atributo1,atributo2,atributo3,...,valor da locação
    }

    public void exibeDadosQualidade() {
//		lê a qualidade
//		de vídeo. Se não existir a qualidade indicada, mostra a mensagem de erro:
//		5:Qualidade inexistente.
//		Se existir, mostra os dados do(s) vídeos(s) no formato:
//		5:atributo1,atributo2,atributo3,...,valor da locação
    }

    public void exibeDadosMusicaDuracao() {
//		localiza a música cadastrada
//		com maior duração. Se não existir nenhuma música cadastrada, mostra a
//		mensagem de erro: 6:Nenhuma música encontrada.
    }

    public void removeMidia() {
//	: lê o código de uma mídia. Se não existir uma mídia com o
//		código indicado, mostra a mensagem de erro: 7:codigo inexistente.
//		Se existir, mostra os dados da mídia no formato:
//		7:atributo1,atributo2,atributo3,...,valor da locação e depois a
//		remove do sistema.
    }

    public void somatorioLocacoes() {
//		calcula o somatório do
//			valor de locação de todas as mídias do sistema. Se não existir mídia cadastrada
//		no sistema, mostra a mensagem de erro: 8:Nenhuma mídia encontrada.
//				Se existir, mostra a mensagem no formato: 8:valor do somatório
    }

    public void exibeDadosMusicaLocacaoMedia() {
//		calcula a média dos valores de locações das músicas
//		cadastradas e localiza a música com valor de locação mais próximo da média
//		calculada. Se não existir nenhuma música cadastrada, mostra a mensagem de erro:
//		9:Nenhuma musica encontrada
    }

    public void exibeDadosMidiaNova() {
//		mostra os dados da mídia mais nova. Se não
//		existir nenhuma mídia cadastrada, mostra a mensagem de erro: 10:Nenhuma midia
//		encontrada.
//				Se existir, mostra os dados da mídia no formato: 10:codigo,titulo,ano

    }

}
