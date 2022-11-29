package com.example.controle_de_patrimonio_java;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.controle_de_patrimonio_java.models.SuperAppView;

public class MainView extends SuperAppView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        startActivity(new Intent(getApplicationContext(), com.example.controle_de_patrimonio_java.activity.InventarioView.class));

    }
}