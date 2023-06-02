package model;

import java.io.IOException;
import java.util.Scanner;

public class PessoaJuridicaService {

    public static String cadastrar(Scanner escanner, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Digite o Id da Empresa:");
        int id = escanner.nextInt();

        System.out.println("Digite o Nome da Empresa:");
        String nome = escanner.next();
        
        System.out.println("Digite o CNPJ da Empresa:");
        String cnpj = escanner.next();

        pessoaJuridicaRepo.inserir(new PessoaJuridica(id, nome, cnpj));

        return "Pessoa Juridica Cadastrada com Sucesso!";
    }

    public static String alterar(Scanner escanner, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Digite o Id da Empresa:");
        int id = escanner.nextInt();
        PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(id);
        pessoaJuridica.exibir();

        System.out.println("Digite o Nome da Empresa:");
        String nome = escanner.next();

        System.out.println("Digite o CNPJ da Empresa:");
        String cnpj = escanner.next();

        pessoaJuridica.setNome(nome);
        pessoaJuridica.setCnpj(cnpj);

        pessoaJuridicaRepo.alterar(id, pessoaJuridica);

        return "Pessoa Juridica Alterada com Sucesso!";
    }

    public static String excluir(Scanner escanner, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Digite o Id da Empresa:");
        int id = escanner.nextInt();

        pessoaJuridicaRepo.excluir(id);
        return "Pessoa Juridica Excluida com Sucesso!";
    }

    public static String obter(Scanner escanner, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Digite o Id da Empresa:");
        int id = escanner.nextInt();
        PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(id);
        pessoaJuridica.exibir();
        return "Pessoa Juridica Exibida com Sucesso!";
    }

    public static String exibir(Scanner escanner, PessoaJuridicaRepo pessoaJuridicaRepo) {
        for (PessoaJuridica pj : pessoaJuridicaRepo.obterTodos()) {
            pj.exibir();
        }
        return "Lista Exibida com sucesso!";
    }

    public static String salvar(Scanner escanner, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Digite o Nome do arquivo:");
        String nome = escanner.next();

        try {
            pessoaJuridicaRepo.persistir(nome);
            return "Dados Salvo no arquivo " + nome + ".juridica.bin";
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao Salvar o arquivo " + nome + ".juridica.bin";
        }

    }

    public static String recuperar(Scanner escanner, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Digite o Nome do arquivo:");
        String nome = escanner.next();

        try {
            pessoaJuridicaRepo.recuperar(nome);
            return "Dados de Pessoas Juridica Recuperados!";
        } catch (ClassNotFoundException | IOException e) {
            return "Arquivo não encontrado!";
        }

    }
}