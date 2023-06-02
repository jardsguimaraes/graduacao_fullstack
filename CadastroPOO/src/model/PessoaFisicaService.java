package model;

import java.io.IOException;
import java.util.Scanner;

public class PessoaFisicaService {

    public static String cadastrar(Scanner escanner, PessoaFisicaRepo pessoaFisicaRepo) {
        System.out.println("Digite o Id da Pessoa:");
        int id = escanner.nextInt();

        System.out.println("Digite o Nome da Pessoa:");
        String nome = escanner.next();

        System.out.println("Digite o CPF da Pessoa:");
        String cpf = escanner.next();

        System.out.println("Digite a Idade da Pessoa:");
        int idade = escanner.nextInt();

        pessoaFisicaRepo.inserir(new PessoaFisica(id, nome, cpf, idade));

        return "Pessoa Fisica Cadastrada com Sucesso!";
    }

    public static String alterar(Scanner escanner, PessoaFisicaRepo pessoaFisicaRepo) {
        System.out.println("Digite o Id da Pessoa:");
        int id = escanner.nextInt();
        PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(id);
        pessoaFisica.exibir();

        System.out.println("Digite o Nome da Pessoa:");
        String nome = escanner.next();

        System.out.println("Digite o CPF da Pessoa:");
        String cpf = escanner.next();

        System.out.println("Digite a Idade da Pessoa:");
        int idade = escanner.nextInt();

        pessoaFisica.setNome(nome);
        pessoaFisica.setCpf(cpf);
        pessoaFisica.setIdade(idade);

        pessoaFisicaRepo.alterar(id, pessoaFisica);

        return "Pessoa Fisica Alterada com Sucesso!";
    }

    public static String excluir(Scanner escanner, PessoaFisicaRepo pessoaFisicaRepo) {
        System.out.println("Digite o Id da Pessoa:");
        int id = escanner.nextInt();

        pessoaFisicaRepo.excluir(id);
        return "Pessoa Fisica Excluida com Sucesso!";
    }

    public static String obter(Scanner escanner, PessoaFisicaRepo pessoaFisicaRepo) {
        System.out.println("Digite o Id da Pessoa:");
        int id = escanner.nextInt();
        PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(id);
        pessoaFisica.exibir();
        return "Pessoa Fisica Exibida com Sucesso!";
    }

    public static String exibir(Scanner escanner, PessoaFisicaRepo pessoaFisicaRepo) {
        for (PessoaFisica pf : pessoaFisicaRepo.obterTodos()) {
            pf.exibir();
        }
        return "Lista Exibida com sucesso!";
    }

    public static String salvar(Scanner escanner, PessoaFisicaRepo pessoaFisicaRepo) {
        System.out.println("Digite o Nome do arquivo:");
        String nome = escanner.next();

        try {
            pessoaFisicaRepo.persistir(nome);
            return "Dados Salvo no arquivo " + nome + ".fisica.bin";
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao Salvar o arquivo " + nome + ".juridica.bin";
        }

    }

    public static String recuperar(Scanner escanner, PessoaFisicaRepo pessoaFisicaRepo) {
        System.out.println("Digite o Nome do arquivo:");
        String nome = escanner.next();

        try {
            pessoaFisicaRepo.recuperar(nome);
            return "Dados de Pessoas Física Recuperados!";
        } catch (ClassNotFoundException | IOException e) {
            return "Arquivo não encontrado!";
        }

    }
}