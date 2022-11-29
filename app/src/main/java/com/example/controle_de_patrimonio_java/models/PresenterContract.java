package com.example.controle_de_patrimonio_java.models;

/**
 * @author Matheus Martinelli
 * Created on *28-11-2022
 * martinelli.matheus2@gmail.com
 */

/**
 * Interface que agrupa os método comuns a todas as activitys
 */
public interface PresenterContract {


    /**
     * Lista todos os ativos do banco de dados e armazena na AtivosList
     */
    void listarAtivos();

    /**
     * Contrato da activity Inventario
     */
    interface InventarioContract extends PresenterContract {
        /**
         * Método que recebe a descrição pesquisa no banco de dados e retorna o ativo
         *
         * @param descricao
         * @return
         */
        Ativo getAtivo(String descricao);

        /**
         * Método que recebe a posicao pesquisa no banco de dados e retorna o ativo
         *
         * @param position
         * @return
         */
        Ativo getAtivo(int position);

        /**
         * Recebe um ativo e atualiza o valor depreciado no banco de dados
         * @param ativo
         * @return
         */
        boolean depreciarAtivo(Ativo ativo);

        /**
         * Apaga um ativo do banco de dados
         * @param ativo
         */
        void liquidarAtivo(Ativo ativo);
    }


    /**
     * Contrato da activity Cadastro
     */

    interface CadastroContract extends PresenterContract {

        /**
         * Método que cadastra um ativo no banco de dados
         *
         * @param ativo recebe nome e valor
         */
        void cadastrarAtivo(Ativo ativo);

        /**
         * Verifica se o ativo ja esta cadastrado no banco de dados
         *
         * @param descricao Nome do ativo
         * @return false se não houver e true se houver no banco de dados
         */
        boolean existsAtivo(String descricao);


    }
}
