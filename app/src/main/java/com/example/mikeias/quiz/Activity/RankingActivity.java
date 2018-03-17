package com.example.mikeias.quiz.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mikeias.quiz.Dao.PontuacaoDAO;
import com.example.mikeias.quiz.Pontuacao;
import com.example.mikeias.quiz.R;

public class RankingActivity extends AppCompatActivity {
    private TextView edtRanking;
    private TextView edtUltimaPontuacao;
    private int ranking         = 0;
    private int ultimaPontuacao = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Ranking");     //Titulo para ser exibido na sua Action Bar em frente à seta

        edtRanking         = findViewById(R.id.edtRanking);
        edtUltimaPontuacao = findViewById(R.id.edtUltimaPontuacao);

        Pontuacao pont = new Pontuacao(0, ranking, ultimaPontuacao);
        ranking = pont.getRanking();
        ultimaPontuacao = pont.getUltimaPontuacao();

        /*Intent intent = getIntent();
        int pontos = intent.getIntExtra("pontos", 0);*/

        if (ultimaPontuacao > ranking) {
            ranking = ultimaPontuacao;
        }
        edtRanking.setText("Ranking " + ranking + " ponto(s)");
        edtUltimaPontuacao.setText("Ultima pontuação: " + ultimaPontuacao + " ponto(s)");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, SplashScreen.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

}
