import java.util.Scanner;

import model.PessoaFisicaRepo;
import model.PessoaFisicaService;
import model.PessoaJuridicaRepo;
import model.PessoaJuridicaService;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner escanner = new Scanner(System.in);
        int opcao = -1;
        String resposta;
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        while (opcao != 0) {
            System.out.println("===================================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar por Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("===================================================");
            opcao = escanner.nextInt();

            switch (opcao) {
                case 1:
                    resposta = pessoa(escanner).equals("F")
                            ? PessoaFisicaService.cadastrar(escanner, pessoaFisicaRepo)
                            : PessoaJuridicaService.cadastrar(escanner, pessoaJuridicaRepo);
                    System.out.println(resposta);
                    break;
                case 2:
                    resposta = pessoa(escanner).equals("F")
                            ? PessoaFisicaService.alterar(escanner, pessoaFisicaRepo)
                            : PessoaJuridicaService.alterar(escanner, pessoaJuridicaRepo);
                    System.out.println(resposta);
                    break;
                case 3:
                    resposta = pessoa(escanner).equals("F")
                            ? PessoaFisicaService.excluir(escanner, pessoaFisicaRepo)
                            : PessoaJuridicaService.excluir(escanner, pessoaJuridicaRepo);
                    System.out.println(resposta);
                    break;
                case 4:
                    resposta = pessoa(escanner).equals("F")
                            ? PessoaFisicaService.obter(escanner, pessoaFisicaRepo)
                            : PessoaJuridicaService.obter(escanner, pessoaJuridicaRepo);
                    System.out.println(resposta);
                    break;
                case 5:
                    resposta = pessoa(escanner).equals("F")
                            ? PessoaFisicaService.exibir(escanner, pessoaFisicaRepo)
                            : PessoaJuridicaService.exibir(escanner, pessoaJuridicaRepo);
                    System.out.println(resposta);
                    break;
                case 6:
                    resposta = pessoa(escanner).equals("F")
                            ? PessoaFisicaService.salvar(escanner, pessoaFisicaRepo)
                            : PessoaJuridicaService.salvar(escanner, pessoaJuridicaRepo);
                    System.out.println(resposta);
                    break;
                case 7:
                    resposta = pessoa(escanner).equals("F")
                            ? PessoaFisicaService.recuperar(escanner, pessoaFisicaRepo)
                            : PessoaJuridicaService.recuperar(escanner, pessoaJuridicaRepo);
                    System.out.println(resposta);
                    break;
                case 0:
                    System.out.println("Programa Finalizado com Sucesso!");
                    System.exit(0);
                default:
                    System.out.println("Digite uma das opções entre 0 - 7");
                    break;
            }
        }

    }

    private static String pessoa(Scanner escanner) {
        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
        String selecao = escanner.next().toUpperCase();
        if (!(selecao.equals("F") || selecao.equals("J"))) {
            pessoa(escanner);
        }
        return selecao;
    }

}