package modelo;

public class cadAtleta {
    private int idAtleta;
    private String nomeAtleta;
    private String cpfAtleta;
    private String sexo;
    private int idadeAtleta;
    private String equipe;
    private String senha;

    // Construtor padrão
    public cadAtleta() {}

    // Construtor com parâmetros
    public cadAtleta(String nomeAtleta, String cpfAtleta, String sexo, int idadeAtleta, String equipe, String senha) {
        this.nomeAtleta = nomeAtleta;
        this.cpfAtleta = cpfAtleta;
        this.sexo = sexo;
        this.idadeAtleta = idadeAtleta;
        this.equipe = equipe;
        this.senha = senha;
    }

    // Getters e setters
    public int getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(int idAtleta) {
        this.idAtleta = idAtleta;
    }

    public String getNomeAtleta() {
        return nomeAtleta;
    }

    public void setNomeAtleta(String nomeAtleta) {
        this.nomeAtleta = nomeAtleta;
    }

    public String getCpfAtleta() {
        return cpfAtleta;
    }

    public void setCpfAtleta(String cpfAtleta) {
        this.cpfAtleta = cpfAtleta;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdadeAtleta() {
        return idadeAtleta;
    }

    public void setIdadeAtleta(int idadeAtleta) {
        this.idadeAtleta = idadeAtleta;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
