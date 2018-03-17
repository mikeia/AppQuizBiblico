package com.example.mikeias.quiz;

import java.io.Serializable;

/**
 * Created by Mikeias on 16/12/2017.
 */
public class Pontuacao implements Serializable {

    private int id;
    private int ranking;
    private int ultimaPontuacao;

    public Pontuacao(int id, int ranking, int ultimaPontuacao){
        this.id = id;
        this.ranking = ranking;
        this.ultimaPontuacao = ultimaPontuacao;
    }

    public int getId(){ return this.id; }
    public int getRanking() {
        return this.ranking;
    }
    public int getUltimaPontuacao() {
        return this.ultimaPontuacao;
    }

    @Override
    public boolean equals(Object o){
        return this.id == ((Pontuacao)o).id;
    }

    @Override
    public int hashCode(){
        return this.id;
    }
}