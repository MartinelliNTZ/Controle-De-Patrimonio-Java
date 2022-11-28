package com.example.controle_de_patrimonio_java.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.controle_de_patrimonio_java.R;
import com.example.controle_de_patrimonio_java.models.Ativo;
import com.example.controle_de_patrimonio_java.models.SuperAppView;
import com.example.controle_de_patrimonio_java.models.ViewContract;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class InventarioView extends SuperAppView implements ViewContract.InventarioView {
    private Button btCadastrarInventario;
    private InventarioPresenter presenter;
    private ListView listView;
    protected DecimalFormat decimalFormat = new DecimalFormat("###,##0,00");
    Locale ptBr = new Locale("pt", "BR");
    private final NumberFormat numberFormat =NumberFormat.getCurrencyInstance(ptBr);

    @Override
    protected void onResume() {
        super.onResume();
        presenter.listarAtivos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        hideBar();
        linkage();
        listenners();
        presenter = new InventarioPresenter(this,getApplicationContext());


    }

    @Override
    public void hideBar() {
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    @Override
    public void setListView(List<Ativo> ativos) {

        ArrayList<String> resultado= new ArrayList<>();
        for (int i = 0; i < ativos.size(); i++) {
            String x = "Ativo: " + ativos.get(i).getDescricao() + "  " + numberFormat.format(ativos.get(i).getValor());
            resultado.add(x);
        }
        ArrayAdapter<String> meuAdaptador=new ArrayAdapter<String>(this,
                //R.layout.lista_personalizada,
                android.R.layout.select_dialog_singlechoice,
                android.R.id.text1,resultado);
        listView.setAdapter(meuAdaptador);

        listView.setOnItemClickListener((parent, view, position, id) -> {

           // Log.i("cox", "onItemClick: "+parent.getSelectedItem().toString());
        });
    }


    @Override
    public void linkage() {
        btCadastrarInventario = findViewById(R.id.btCadastrarInventario);
        listView = findViewById(R.id.listViewInventario);

    }

    @Override
    public void listenners() {
        btCadastrarInventario.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), com.example.controle_de_patrimonio_java.activity.CadastroView.class)));
    }
}