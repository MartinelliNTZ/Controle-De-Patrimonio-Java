package com.example.controle_de_patrimonio_java.models;

import android.content.Context;

import com.example.controle_de_patrimonio_java.database.AtivoDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matheus Martinelli
 * Created on *28-11-2022
 * martinelli.matheus2@gmail.com
 */
public class SuperAppPresenter<T extends ViewContract> implements PresenterContract{
    protected AtivoDAO ativoDAO;
    protected List<Ativo> ativoList = new ArrayList<>();
    protected T view;

    public SuperAppPresenter(T view, Context context) {
        this.view = view;
        ativoDAO = new AtivoDAO(context);
    }

    @Override
    public void listarAtivos() {
        ativoList = ativoDAO.listar();
    }
}
