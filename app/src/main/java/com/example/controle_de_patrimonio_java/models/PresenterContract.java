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
    interface InventarioContract extends PresenterContract{

    }

    /**
     * Contrato da activity Cadastro
     */
    interface CadastroContract extends PresenterContract{

        /**
         * Método que cadastra um ativo no banco de dados
         * @param ativo recebe nome e valor
         */
        void cadastrarAtivo(Ativo ativo);

        /**
         * Verifica se o ativo ja esta cadastrado no banco de dados
         * @param descricao Nome do ativo
         * @return false se não houver e true se houver no banco de dados
         */
        boolean existsAtivo(String descricao);
    }
}
