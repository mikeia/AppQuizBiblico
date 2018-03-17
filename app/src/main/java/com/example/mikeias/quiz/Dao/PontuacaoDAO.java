package com.example.mikeias.quiz.Dao;

/**
 * Created by Mikeias on 16/12/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.mikeias.quiz.DbGateway;
import com.example.mikeias.quiz.Pontuacao;

import java.util.ArrayList;
import java.util.List;

public class PontuacaoDAO {

    private final String TABLE_PONTUACAO = "Pontuacao";
    private DbGateway gw;

    public PontuacaoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }
    public boolean salvar(int id,int ranking, int ultimaPontuacao){
        ContentValues cv = new ContentValues();
        cv.put("Ranking", ranking);
        cv.put("UltimaPontuacao", ultimaPontuacao);
        if(id > 0)
            return gw.getDatabase().update(TABLE_PONTUACAO, cv, "ID=?", new String[]{ id + "" }) > 0;
        else
            return gw.getDatabase().insert(TABLE_PONTUACAO, null, cv) > 0;
    }
    public boolean salvar(int ranking, int ultimaPontuacao){
        return salvar(0, ranking, ultimaPontuacao);
    }
    public List<Pontuacao> retornarTodos(){
        List<Pontuacao> pontuacao = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Pontuacao", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            int ranking = cursor.getInt(cursor.getColumnIndex("Ranking"));
            int ultimaPontuacao = cursor.getInt(cursor.getColumnIndex("UltimaPontuacao"));

            pontuacao.add(new Pontuacao(id, ranking, ultimaPontuacao));
        }
        cursor.close();
        return pontuacao;
    }




}
