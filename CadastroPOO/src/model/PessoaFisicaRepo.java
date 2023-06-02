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

    public void alterar(int id, PessoaFisica pf) {
        listaDePessoasFisica.set(buscarIndex(id), pf);
    }

    public void excluir(int id) {
        listaDePessoasFisica.remove(buscarIndex(id));
    }

    public PessoaFisica obter(int id) {
        return listaDePessoasFisica.get(buscarIndex(id));
    }

    private int buscarIndex(int id) {
        for (PessoaFisica pf : listaDePessoasFisica) {
            if (pf.getId() == id) {
                return listaDePessoasFisica.indexOf(pf);
            }
        }
        return -1;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return listaDePessoasFisica;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fout = new FileOutputStream("src\\files\\" + nomeArquivo + ".fisica.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(this.listaDePessoasFisica);
            System.out.println("Dados de Pessoa Física Armazenados.");
        }
    }

    public void recuperar(String nomeArquivo) throws ClassNotFoundException, IOException{
        try (FileInputStream fin = new FileInputStream("src\\files\\" + nomeArquivo + ".fisica.bin");
                ObjectInputStream ois = new ObjectInputStream(fin)) {
            listaDePessoasFisica = (ArrayList<PessoaFisica>) ois.readObject();
        } 

    }
}