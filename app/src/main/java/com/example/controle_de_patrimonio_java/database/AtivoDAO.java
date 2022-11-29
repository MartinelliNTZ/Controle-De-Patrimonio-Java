package com.example.controle_de_patrimonio_java.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.controle_de_patrimonio_java.models.IModelDAO;
import com.example.controle_de_patrimonio_java.models.ModelDAO;
import com.example.controle_de_patrimonio_java.models.Ativo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matheus Martinelli
 * Created on *27-11-2022
 * martinelli.matheus2@gmail.com
 */
public class AtivoDAO extends ModelDAO implements IModelDAO<Ativo> {

    public AtivoDAO(Context context) {
        super(context);
    }


    @Override
    public boolean salvar(Ativo ativo) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("descricao", ativo.getDescricao());
            cv.put("valor", (ativo.getValor()));
            escreve.insert(DbHelper.TABELA_ATIVOS, null, cv);
            Log.i("INFO COX", "Ativo " + ativo.getDescricao() + " criado com Sucesso. " + cv);
            listar();
            return true;
        } catch (Exception e) {
            Log.i("INFO COX", "ERRO ao salvar ativos. COD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizar(Ativo ativo) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("descricao", ativo.getDescricao());
            cv.put("valor", ativo.getValor());
            String[] args = {String.valueOf(ativo.getId())};
            escreve.update(DbHelper.TABELA_ATIVOS, cv, "id=?", args);
            Log.i("INFO COX", "Ativo " + ativo.getDescricao() + " alterada com Sucesso.");
            return true;
        } catch (Exception e) {
            Log.i("INFO COX", "ERRO ao alterar ativo. COD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletar(Ativo ativo) {
        try {
            String[] args = {String.valueOf(ativo.getId())};
            escreve.delete(DbHelper.TABELA_ATIVOS, "id=?", args);
            Log.i("INFO COX", "Ativo " + ativo.getDescricao() + " deletado com Sucesso.");
            return true;
        } catch (Exception e) {
            Log.i("INFO COX", "ERRO ao deletar ativo. COD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Ativo> listar() {
        try {
            List<Ativo> ativoList = new ArrayList<>();
            String sql = "SELECT * FROM " + DbHelper.TABELA_ATIVOS + " ;";
            Cursor cursor = le.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                @SuppressLint("Range") Long id = cursor.getLong(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
                @SuppressLint("Range") Double valor = cursor.getDouble(cursor.getColumnIndex("valor"));
                ativoList.add(new Ativo(id, descricao, valor));
            }
            return ativoList;
        } catch (Exception e) {
            Log.i("COX", "Erro ao listar produtos: " + e.getMessage());
            return null;
        }
    }
}
