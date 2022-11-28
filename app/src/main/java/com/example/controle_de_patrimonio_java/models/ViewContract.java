package com.example.controle_de_patrimonio_java.models;

/**
 * @author Matheus Martinelli
 * Created on *27-11-2022
 * martinelli.matheus2@gmail.com
 */

import java.util.List;

/**
 * Interface comum as duas activitys
 * Os métodos declarados aqui devem ser implementados em todas as activitys
 */
public interface ViewContract {

    /**
     * Métod que faz a ligação da activity com os widgets da view
     */
    void linkage();
    /**
     * Método que agrupa todos os listeners da aplicação
     */
    void listenners();
    /**
     * Exibe um toast com uma mesagem
     */
    void showMessage(String message);
    /**
     * Exibe um alert com uma mesagem
     */
    void showMessage(String title,String message);
    /**
     * Exibe um alert com uma mesagem
     */
    void showMessageError(String title,String message);


    /**
     * Interface expecifica da Activity Inventario
     */
    interface InventarioView extends ViewContract{
        /**
         * Esconde a actionBar
         */
        void hideBar();

        /**
         * Método que atualiza o listview
         * @param ativos lista com os ativos que devem ser exibidos na dela
         */
        void setListView(List<Ativo> ativos);

    }
    /**
     * Interface expecifica da Activity Cadastro
     */
    interface CadastroView extends ViewContract{
        /**
         * Configura o botão voltar na actionBar
         */
        void configBar();

        /**
         * Método que valida os campos digitados
         */
        boolean validarCampos();

    }
}
