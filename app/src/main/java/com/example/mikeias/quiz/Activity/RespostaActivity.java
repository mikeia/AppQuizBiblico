package com.example.mikeias.quiz.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mikeias.quiz.Dao.PontuacaoDAO;
import com.example.mikeias.quiz.R;

public class RespostaActivity extends AppCompatActivity {
    private int pontos;
    private ImageView imgResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
        getSupportActionBar().hide();

        ImageView imgResposta    = findViewById(R.id.imgResposta);
        TextView resposta        = findViewById(R.id.resposta);
        Button btnJogarNovamente = findViewById(R.id.jogarNovamente);
        Button btnRanking        = findViewById(R.id.btn_ranking);

        Intent intent = getIntent();
        pontos = intent.getIntExtra("pontos", 0);

        int ptRanking         = pontos;
        int ptUltimaPontuacao = pontos;
        PontuacaoDAO dao      = new PontuacaoDAO(getBaseContext());
        dao.salvar(ptRanking, ptUltimaPontuacao);

        if (intent.hasExtra("acertou")) {
            btnJogarNovamente.setVisibility(View.INVISIBLE);
            btnRanking.setVisibility(View.INVISIBLE);
            boolean acertou = intent.getBooleanExtra("acertou", false);
            if (acertou) {
                imgResposta.setImageResource(R.drawable.positivo);
                resposta.setText("Acertou! Pontos: " + pontos);
            } else {
                imgResposta.setImageResource(R.drawable.negativo);
                resposta.setText("Errou! Pontos: " + pontos);
            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });
            thread.start();
        } else {
            btnJogarNovamente.setVisibility(View.VISIBLE);
            btnRanking.setVisibility(View.VISIBLE);


            if (pontos >= 3) {
                imgResposta.setImageResource(R.drawable.muitobem);
                resposta.setText("Parabéns você fez " + pontos + " pontos!");
            }else {
                imgResposta.setImageResource(R.drawable.quepena);
                resposta.setText("Que pena você fez " + pontos + " pontos!");
            }
        }
    }

    public void btnJogarNovamenteOnClick(View v){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnRankingOnClick(View view) {
        Intent intent = new Intent(this, RankingActivity.class);
        intent.putExtra("pontos", pontos);
        startActivity(intent);
        finish();
    }
}

