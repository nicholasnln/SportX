package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.cadAtleta;

public class CadastroDao implements DaoGenerica<cadAtleta> {
    private ConexaoBanco conexao;

    public CadastroDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(cadAtleta cadastro) {
        String sql = "INSERT INTO cadAtleta (nomeAtleta, cpfAtleta, sexo, idadeAtleta, Equipe, senha) VALUES (?,?,?,?,?,?)";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, cadastro.getNomeAtleta());
                sentenca.setString(2, cadastro.getCpfAtleta());
                sentenca.setString(3, cadastro.getSexo()); // Usando o novo campo sexo
                sentenca.setInt(4, cadastro.getIdadeAtleta());
                sentenca.setString(5, cadastro.getEquipe());
                sentenca.setString(6, cadastro.getSenha());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public cadAtleta consultarPorCPF(String cpf) {
        String sql = "SELECT * FROM cadAtleta WHERE cpfAtleta = ?";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setString(1, cpf);
                ResultSet resultadoSentenca = sentenca.executeQuery();

                if (resultadoSentenca.next()) {
                    cadAtleta atleta = new cadAtleta();
                    atleta.setIdAtleta(resultadoSentenca.getInt("idAtleta"));
                    atleta.setNomeAtleta(resultadoSentenca.getString("nomeAtleta"));
                    atleta.setCpfAtleta(resultadoSentenca.getString("cpfAtleta"));
                    atleta.setSexo(resultadoSentenca.getString("sexo")); // Recuperando o novo campo sexo
                    atleta.setIdadeAtleta(resultadoSentenca.getInt("idadeAtleta"));
                    atleta.setEquipe(resultadoSentenca.getString("Equipe"));
                    atleta.setSenha(resultadoSentenca.getString("senha"));
                    return atleta;
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public void alterar(cadAtleta cadastro) {
        String sql = "UPDATE cadAtleta SET nomeAtleta = ?, cpfAtleta = ?, sexo = ?, idadeAtleta = ?, Equipe = ? WHERE idAtleta = ?";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, cadastro.getNomeAtleta());
                sentenca.setString(2, cadastro.getCpfAtleta());
                sentenca.setString(3, cadastro.getSexo()); // Usando o novo campo sexo
                sentenca.setInt(4, cadastro.getIdadeAtleta());
                sentenca.setString(5, cadastro.getEquipe());
                sentenca.setInt(6, cadastro.getIdAtleta());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM cadAtleta WHERE idAtleta = ?";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setInt(1, id);

                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ArrayList<cadAtleta> consultar() {
        ArrayList<cadAtleta> listaCadastros = new ArrayList<cadAtleta>();
        String sql = "SELECT idAtleta, nomeAtleta, cpfAtleta, sexo, idadeAtleta, Equipe FROM cadAtleta ORDER BY idAtleta";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    cadAtleta cadastro = new cadAtleta();
                    cadastro.setIdAtleta(resultadoSentenca.getInt("idAtleta"));
                    cadastro.setNomeAtleta(resultadoSentenca.getString("nomeAtleta"));
                    cadastro.setCpfAtleta(resultadoSentenca.getString("cpfAtleta"));
                    cadastro.setSexo(resultadoSentenca.getString("sexo")); // Recuperando o novo campo sexo
                    cadastro.setIdadeAtleta(resultadoSentenca.getInt("idadeAtleta"));
                    cadastro.setEquipe(resultadoSentenca.getString("Equipe"));

                    listaCadastros.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaCadastros;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<cadAtleta> consultar(String str) {
        ArrayList<cadAtleta> listaCadastrosStr = new ArrayList<cadAtleta>();
        String sql = "SELECT idAtleta, nomeAtleta, cpfAtleta, sexo, idadeAtleta, Equipe FROM cadAtleta WHERE UPPER(nomeAtleta) LIKE UPPER(?) ORDER BY nomeAtleta";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, "%" + str + "%");

                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    cadAtleta cadastro = new cadAtleta();
                    cadastro.setIdAtleta(resultadoSentenca.getInt("idAtleta"));
                    cadastro.setNomeAtleta(resultadoSentenca.getString("nomeAtleta"));
                    cadastro.setCpfAtleta(resultadoSentenca.getString("cpfAtleta"));
                    cadastro.setSexo(resultadoSentenca.getString("sexo")); // Recuperando o novo campo sexo
                    cadastro.setIdadeAtleta(resultadoSentenca.getInt("idadeAtleta"));
                    cadastro.setEquipe(resultadoSentenca.getString("Equipe"));

                    listaCadastrosStr.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaCadastrosStr;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
