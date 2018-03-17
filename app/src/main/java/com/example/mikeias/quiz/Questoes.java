package com.example.mikeias.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikeias on 16/12/2017.
 */

public class Questoes {
    private String pergunta;
    private List<String> respostas = new ArrayList<>();
    private int respostaCerta;

    public Questoes(String pergunta, int respostaCerta, String... respostas){
        this.pergunta = pergunta;
        this.respostaCerta = respostaCerta;
        this.respostas.add(respostas[0]);
        this.respostas.add(respostas[1]);
        this.respostas.add(respostas[2]);

    }

    public String getPergunta(){ return this.pergunta; }
    public List<String> getRespostas(){ return this.respostas; }
    public int getRespostaCerta(){ return this.respostaCerta; }
}
