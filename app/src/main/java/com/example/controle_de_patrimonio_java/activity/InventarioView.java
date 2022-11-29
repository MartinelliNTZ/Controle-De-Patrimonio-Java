package com.example.controle_de_patrimonio_java.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;

import com.example.controle_de_patrimonio_java.R;
import com.example.controle_de_patrimonio_java.models.Ativo;
import com.example.controle_de_patrimonio_java.models.SuperAppView;
import com.example.controle_de_patrimonio_java.models.ViewContract;
import com.example.controle_de_patrimonio_java.my_codes.CustomAlerts;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class InventarioView extends SuperAppView implements ViewContract.InventarioView {
    private Button btCadastrarInventario, btDepreciar, btLiquidar;
    private InventarioPresenter presenter;
    private ListView listView;
    private Locale ptBr = new Locale("pt", "BR");
    private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBr);
    private Ativo checkedAtivo;


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
        presenter = new InventarioPresenter(this, getApplicationContext());


    }

    @Override
    public void hideBar() {
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    @Override
    public void setListView(List<Ativo> ativos) {

        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 0; i < ativos.size(); i++) {
            String x = "Ativo: " + ativos.get(i).getDescricao() + "\t\t  " + numberFormat.format(ativos.get(i).getValor());
            resultado.add(x);
        }
        ArrayAdapter meuAdaptador = new ArrayAdapter(this,
                //R.layout.lista_personalizada,
                android.R.layout.simple_list_item_single_choice, resultado);
        listView.setAdapter(meuAdaptador);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener((parent, view, position, id) -> {


        });

    }


    @Override
    public void linkage() {
        btCadastrarInventario = findViewById(R.id.btCadastrarInventario);
        btDepreciar = findViewById(R.id.btDepreciar);
        btLiquidar = findViewById(R.id.btLiquidar);
        listView = findViewById(R.id.listViewInventario);

    }

    @Override
    public void listenners() {
        btCadastrarInventario.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), com.example.controle_de_patrimonio_java.activity.CadastroView.class)));
        btLiquidar.setOnClickListener(v -> {
            Log.i("cox", "listenners: " + listView.getCheckedItemPositions());
            int position = listView.getCheckedItemPosition();
            if (position>=0) {
                checkedAtivo = presenter.getAtivo(position);
                CustomAlerts.imputDecimalDialog(this, "Liquidar " +checkedAtivo.getDescricao()+" ?",
                                "A liquidação é ireversivel e só pode ocorrer se o ativo estiver com valor abaixo de R$00,00.")
                        .setPositiveButton("OK", (dialog, which) -> {
                            if(checkedAtivo.getValor()<=0.0) presenter.depreciarAtivo(checkedAtivo);
                        })
                        .create().show();
            }  else {
            showMessage("Selecione um item.");
        }
        });
        btDepreciar.setOnClickListener(v -> {
            int position = listView.getCheckedItemPosition();

            if (position >= 0) {
                checkedAtivo = presenter.getAtivo(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Depreciar " + checkedAtivo.getDescricao() + " ?");
                Double min = checkedAtivo.getValor() * .1;
                builder.setMessage("O valor minimo de depreciação é " + numberFormat.format(min)
//                         +"\n O valor maximo de depreciação é " + numberFormat.format(checkedAtivo.getValor())
                );

                final EditText input = new EditText(this);
                input.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                input.setHint("99.99");
                builder.setView(input);

                builder.setPositiveButton("OK", (dialog, which) -> {
                    try {
                        double value = Double.parseDouble(input.getText().toString());
                        if (value >= min
//                               && value <= checkedAtivo.getValor()
                        ) {
                            checkedAtivo.setValor(checkedAtivo.getValor() - value);
                            presenter.depreciarAtivo(checkedAtivo);
                        } else {
                            showMessage("O valor inserido é inválido.");
                        }
                    } catch (Exception e) {
                        showMessage("Caracteres inválidos");
                    }
                });
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

                builder.create().show();
            } else {
                showMessage("Selecione um item.");
            }
        });

    }
}