package com.example.controle_de_patrimonio_java.models;

import java.util.List;


public interface IModelDAO<T> {


        /**
         * Método que salva o objeto selecionado no SQLite
         * @param t recebe o objeto que se deseja salvar
         * */
        public boolean salvar(T t);
        /**
         * Método que atualiza o objeto selecionado no SQLite
         * @param t recebe o objeto que se deseja atualizar
         * */
        public boolean atualizar(T t);
        /**
         * Método que deleta o objeto selecionado no SQLite
         * @param t recebe o objeto que se deseja deletar
         * */
        public boolean deletar(T t);
        /**
         * Método que retorna uma lista dos objetos armazenados no SQLite
         * @return lista com os objetos presentes no banco de dados
         * */
        public List<T> listar();

}
