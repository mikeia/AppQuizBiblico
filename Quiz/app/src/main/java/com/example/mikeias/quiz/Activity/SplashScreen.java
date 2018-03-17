package com.example.mikeias.quiz.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mikeias.quiz.R;

public class SplashScreen extends AppCompatActivity {

    private int pontos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        pontos = intent.getIntExtra("pontos", 0);
    }

    public void btnJogarOnClick(View view) {
        Intent intent = new Intent(this,QuizActivity.class);
        startActivity(intent);
    }

    public void btn_ranking(View view) {
        Intent intent = new Intent(this, RankingActivity.class);
        intent.putExtra("pontos", pontos);
        startActivity(intent);
    }
}
