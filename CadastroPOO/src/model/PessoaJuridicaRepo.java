package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> listaDePessoasJuridica = new ArrayList<>();

    public void inserir(PessoaJuridica pj) {
        listaDePessoasJuridica.add(pj);
    }

    public void alterar(int indice, PessoaJuridica pj) {
        listaDePessoasJuridica.set(indice, pj);
    }

    public void excluir(int id) {
        listaDePessoasJuridica.remove(id);
    }

    public PessoaJuridica obter(int id) {
        return listaDePessoasJuridica.get(id);
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return listaDePessoasJuridica;
    }

    public void persistir(String nomeArquivo) {
        try (FileOutputStream fout = new FileOutputStream("src\\files\\" + nomeArquivo + ".txt");
                ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(this.listaDePessoasJuridica);
            System.out.println("Dados de Pessoa Juridica Armazenados.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PessoaJuridica> recuperar(String nomeArquivo) {
        try (FileInputStream fin = new FileInputStream("src\\files\\" + nomeArquivo + ".txt");
                ObjectInputStream ois = new ObjectInputStream(fin)) {
            listaDePessoasJuridica = (ArrayList<PessoaJuridica>) ois.readObject();
            System.out.println("Dados de Pessoas Juridica Recuperados.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listaDePessoasJuridica;

    }

}
