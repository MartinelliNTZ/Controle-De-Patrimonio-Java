package com.example.controle_de_patrimonio_java.activity;

import android.content.Context;
import android.view.View;

import com.example.controle_de_patrimonio_java.models.PresenterContract;
import com.example.controle_de_patrimonio_java.models.SuperAppPresenter;
import com.example.controle_de_patrimonio_java.models.ViewContract;

/**
 * @author Matheus Martinelli
 * Created on *28-11-2022
 * martinelli.matheus2@gmail.com
 */
public class InventarioPresenter extends SuperAppPresenter<ViewContract.InventarioView> implements PresenterContract.InventarioContract {


    public InventarioPresenter(ViewContract.InventarioView view, Context context) {
        super(view, context);
    }

    @Override
    public void listarAtivos() {
        super.listarAtivos();
        view.setListView(ativoList);
    }
}
