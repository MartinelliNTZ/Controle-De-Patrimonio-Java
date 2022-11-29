package com.example.controle_de_patrimonio_java.models;

/**
 * @author Matheus Martinelli
 * Created on *27-11-2022
 * martinelli.matheus2@gmail.com
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.controle_de_patrimonio_java.database.DbHelper;

/**
 * Clase mãe de todas a a interface Model(DAO) da implementação MVP
 * Sua função é criar e inicializar os obejos que irão ler e escrever no banco de dados
 */
public class ModelDAO {
    protected SQLiteDatabase escreve;
    protected SQLiteDatabase le;

    public ModelDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        this.escreve = dbHelper.getWritableDatabase();
        this.le = dbHelper.getReadableDatabase();
    }
}
