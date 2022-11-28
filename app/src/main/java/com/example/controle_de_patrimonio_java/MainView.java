package com.example.controle_de_patrimonio_java;

import android.content.Intent;
import android.os.Bundle;

import com.example.controle_de_patrimonio_java.models.SuperAppView;

public class MainView extends SuperAppView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(getApplicationContext(), com.example.controle_de_patrimonio_java.activity.InventarioView.class));
       // setContentView(R.layout.activity_main);
    }
}