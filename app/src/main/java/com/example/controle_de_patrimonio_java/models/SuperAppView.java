package com.example.controle_de_patrimonio_java.models;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.controle_de_patrimonio_java.R;
import com.example.controle_de_patrimonio_java.my_codes.CustomAlerts;

import java.text.DecimalFormat;

/**
 * @author Matheus Martinelli
 * Created on *27-11-2022
 * martinelli.matheus2@gmail.com
 */
public class SuperAppView extends AppCompatActivity  implements ViewContract{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

@Override
    public void showMessage(String title, String message) {
        CustomAlerts.dialog(this,
                        message
                        ,title,
                        R.drawable.ic_info_black_24)
                .setPositiveButton("Ok",null)
                .create().show();
    }

@Override
    public void showMessageError(String title, String message) {
        CustomAlerts.dialog(this,
                        message
                        ,title,
                        R.drawable.ic_error_24)
                .setPositiveButton("Ok",null)
                .create().show();
    }

    @Override
    public void linkage() {

    }

    @Override
    public void listenners() {

    }
}
