package com.example.controle_de_patrimonio_java.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import com.example.controle_de_patrimonio_java.R;
import com.example.controle_de_patrimonio_java.models.Ativo;
import com.example.controle_de_patrimonio_java.models.SuperAppView;
import com.example.controle_de_patrimonio_java.models.ViewContract;

public class CadastroView extends SuperAppView implements ViewContract.CadastroView {
    private Button btCadInventario;
    private EditText edtValor, edtDescricao;
    private CadastroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        linkage();
        listenners();
        configBar();
        presenter = new CadastroPresenter(this,getApplicationContext());
        edtDescricao.requestFocus();

    }

    @Override
    public void configBar() {
        ActionBar ac = getSupportActionBar();
        assert ac != null;
        ac.setDisplayHomeAsUpEnabled(true);
        ac.setTitle("");
        ac.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary)) );
    }

    @Override
    public boolean validarCampos() {
        try {
            if (edtDescricao.getText().length()<=0) {
                edtDescricao.setError("Não pode estar vazio");
                edtDescricao.requestFocus();
                return false;
            }else if (edtValor.getText().length()<=0) {
                edtValor.setError("Não pode estar vazio");
                edtValor.requestFocus();
                return false;
            }
            double valor = Double.parseDouble(edtValor.getText().toString());
            String desc = edtDescricao.getText().toString();
            if (valor<=0) {
                edtValor.setError("Não pode ser menor que zero");
                edtValor.requestFocus();
                return false;
            }else if(presenter.existsAtivo(desc)){
                showMessageError("Erro.", "Ativo já está cadastrado no sistema.");
                return false;
            }
        } catch (NumberFormatException e) {
            showMessageError("Erro", "Ocorreu um erro, por favor digite somente informações validas.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return false;
    }

    @Override
    public void linkage() {
        edtValor = findViewById(R.id.edtValor);
        edtDescricao = findViewById(R.id.edtDescricao);
        btCadInventario = findViewById(R.id.btCadInventario);
    }

    @Override
    public void listenners() {

        btCadInventario.setOnClickListener(v -> {
            if(validarCampos()){
                String descricao = edtDescricao.getText().toString();
                Double valor = Double.parseDouble(edtValor.getText().toString());
                presenter.cadastrarAtivo(new Ativo(descricao,valor));
                finish();
                releaseInstance();
            }
        });
        edtValor.setOnDragListener((v, event) -> {
            edtValor.setError(null);
            return false;
        });
        edtDescricao.setOnDragListener((v, event) -> {
            edtDescricao.setError(null);
            return false;
        });
    }

}