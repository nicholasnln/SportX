package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {   
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;   
    
    public ConexaoBanco() {
        this.servidor = "200.195.171.122";
        this.banco = "grupo12_Nicholas";
        this.usuario = "grupo12";
        this.senha = "rtAuE6DMG8QDEIRp";
    }
    
    public boolean conectar() {
        try {
            // Carregar o driver JDBC (opcional para JDBC 4.0 e posteriores)
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco, this.usuario, this.senha);
            return true;
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver JDBC não encontrado: " + ex.getMessage());
            return false;
        } catch (SQLException ex) {
            System.err.println("Erro de conexão com o banco de dados: " + ex.getMessage());
            return false;
        }
    }
    
    public Connection getConnection() {
        return conexao;
    }
    
    public void desconectar() {
        try {
            if (this.conexao != null && !this.conexao.isClosed()) {
                this.conexao.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao fechar a conexão com o banco de dados: " + ex.getMessage());
        }
    }
}
