package dao;

import java.util.ArrayList;

public interface DaoGenerica<T> {
    
    /**
     * Insere um novo objeto no banco de dados.
     * @param objeto o objeto a ser inserido
     */
    void inserir(T objeto);
    
    /**
     * Altera um objeto existente no banco de dados.
     * @param objeto o objeto a ser alterado
     */
    void alterar(T objeto);
    
    /**
     * Exclui um objeto existente no banco de dados.
     * @param id o identificador do objeto a ser excluído
     */
    void excluir(int id);
    
    /**
     * Consulta e retorna todos os objetos do banco de dados.
     * @return uma lista de objetos
     */
    ArrayList<T> consultar();

    /**
     * Consulta e retorna dados específicos para o dashboard.
     * @return uma lista de objetos com dados para o dashboard
     */
/*    ArrayList<T> dashboard();   */
}
