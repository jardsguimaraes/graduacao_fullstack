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

    public void alterar(int id, PessoaJuridica pj) {
        listaDePessoasJuridica.set(buscarIndex(id), pj);
    }

    private int buscarIndex(int id) {
        for (PessoaJuridica pj : listaDePessoasJuridica) {
            if (pj.getId() == id) {
                return listaDePessoasJuridica.indexOf(pj);
            }
        }

        return -1;
    }

    public void excluir(int id) {
        listaDePessoasJuridica.remove(buscarIndex(id));
    }

    public PessoaJuridica obter(int id) {
        return listaDePessoasJuridica.get(buscarIndex(id));
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return listaDePessoasJuridica;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fout = new FileOutputStream("src\\files\\" + nomeArquivo + ".juridica.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(this.listaDePessoasJuridica);
            System.out.println("Dados de Pessoa Juridica Armazenados.");
        } 
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fin = new FileInputStream("src\\files\\" + nomeArquivo + ".juridica.bin");
                ObjectInputStream ois = new ObjectInputStream(fin)) {
            listaDePessoasJuridica = (ArrayList<PessoaJuridica>) ois.readObject();
        } 

    }

}
