package com.example.controle_de_patrimonio_java.activity;

import android.content.Context;
import android.view.View;

import com.example.controle_de_patrimonio_java.models.Ativo;
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

    @Override
    public Ativo getAtivo(String descricao) {
        for (Ativo atv: ativoList) {
            if (atv.getDescricao().equalsIgnoreCase(descricao)) return atv;
        }
        return null;
    }

    @Override
    public Ativo getAtivo(int position) {
        return ativoList.get(position);
    }

    @Override
    public boolean depreciarAtivo(Ativo ativo) {
        if(ativoDAO.atualizar(ativo)){
            view.showMessage("Sucesso ao modificar "+ativo.getDescricao());
            listarAtivos();
            return true;
        }else{
            view.showMessageError("Ocorreu um erro","");
            return false;
        }
    }

    @Override
    public void liquidarAtivo(Ativo ativo) {
        if (ativoDAO.deletar(ativo)){
            view.showMessage("Sucesso ao liquidar "+ativo.getDescricao());
            listarAtivos();

        }else{
            view.showMessageError("Ocorreu um erro","");
        }
    }
}
