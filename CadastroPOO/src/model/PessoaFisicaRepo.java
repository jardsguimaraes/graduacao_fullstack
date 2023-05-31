package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> listaDePessoasFisica = new ArrayList<>();

    public void inserir(PessoaFisica pf) {
        listaDePessoasFisica.add(pf);
    }

    public void alterar(int indice, PessoaFisica pf) {
        listaDePessoasFisica.set(indice, pf);
    }

    public void excluir(int id) {
        listaDePessoasFisica.remove(id);
    }

    public PessoaFisica obter(int id) {
        return listaDePessoasFisica.get(id);
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return listaDePessoasFisica;
    }

    public void persistir(String nomeArquivo) {
        try (FileOutputStream fout = new FileOutputStream("src\\files\\" + nomeArquivo + ".txt");
                ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(this.listaDePessoasFisica);
            System.out.println("Dados de Pessoa Física Armazenados.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PessoaFisica> recuperar(String nomeArquivo) {
        try (FileInputStream fin = new FileInputStream("src\\files\\" + nomeArquivo + ".txt");
                ObjectInputStream ois = new ObjectInputStream(fin)) {
            listaDePessoasFisica = (ArrayList<PessoaFisica>) ois.readObject();
            System.out.println("Dados de Pessoas Física Recuperados.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listaDePessoasFisica;

    }
}
