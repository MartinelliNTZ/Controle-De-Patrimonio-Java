package com.example.controle_de_patrimonio_java.activity;

import android.content.Context;

import com.example.controle_de_patrimonio_java.models.Ativo;
import com.example.controle_de_patrimonio_java.models.PresenterContract;
import com.example.controle_de_patrimonio_java.models.SuperAppPresenter;
import com.example.controle_de_patrimonio_java.models.ViewContract;

/**
 * @author Matheus Martinelli
 * Created on *28-11-2022
 * martinelli.matheus2@gmail.com
 */
public class CadastroPresenter extends SuperAppPresenter<ViewContract.CadastroView> implements PresenterContract.CadastroContract {


    public CadastroPresenter(ViewContract.CadastroView view, Context context) {
        super(view, context);
    }

    @Override
    public void cadastrarAtivo(Ativo ativo) {

        if (ativoDAO.salvar(ativo)) {
            view.showMessage("Criado com sucesso");
        } else {
            view.showMessageError("Erro ao salvar", "Houve um erro ao salvar o ativo. Tente novamente por favor!");
        }

    }

    @Override
    public boolean existsAtivo(String descricao) {
        listarAtivos();
        for (Ativo a : ativoList) {
            if (descricao.equalsIgnoreCase(a.getDescricao())) {
                return true;
            }
        }
        return false;
    }


}
