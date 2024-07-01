package dao;

import modelo.cadAtleta;

public class AtletaService {
    private CadastroDao cadastroDao;

    public AtletaService() {
        this.cadastroDao = new CadastroDao();
    }

    public void registrarAtleta(String nome, String cpf, String sexo, int idade, String equipe, String senha) {
        cadAtleta atleta = new cadAtleta(nome, cpf, sexo, idade, equipe, senha);
        cadastroDao.inserir(atleta);
    }

    public boolean login(String cpf, String senhaPlana) {
        cadAtleta atleta = cadastroDao.consultarPorCPF(cpf);

        if (atleta != null) {
            // Compara a senha fornecida com a senha armazenada
            return senhaPlana.equals(atleta.getSenha());
        } else {
            return false;
        }
    }
}
