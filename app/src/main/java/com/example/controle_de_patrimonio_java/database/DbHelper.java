package com.example.controle_de_patrimonio_java.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

/**
 * Classe que cria e instancia o banco de dados SQLite
 */
public class DbHelper extends SQLiteOpenHelper {
    public static int VERSION = 1;
    public static String NOME_DB = "patrimonio";
    public static String TABELA_ATIVOS = "ativos";
    private SQLiteDatabase sqLiteDatabasee;

    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);

    }

    /**
     * Método chamado uma unica vez na criacao do app
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabasee = sqLiteDatabase;
        criarAtivos();
    }

    /**
     * Método que cria a tabela de produtos
     */
    private void criarAtivos() {
        String sql = "CREATE TABLE IF NOT EXISTS " +
                TABELA_ATIVOS +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "valor REAL NOT NULL," +
                "descricao TEXT NOT NULL);";
        try {
            sqLiteDatabasee.execSQL(sql);
            Log.i("INFO DB COX", "Sucesso ao criar tabela:  " + TABELA_ATIVOS);
        } catch (Exception e) {
            Log.i("INFO DB COX", "ERRO ao criar tabela:  " + TABELA_ATIVOS + " " + e.getMessage());
        }
    }

    /**
     * método ultilizado na atualizacao dos dados
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
