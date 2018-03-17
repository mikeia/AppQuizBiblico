package com.example.mikeias.quiz.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.mikeias.quiz.Questoes;
import com.example.mikeias.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView pergunta;
    RadioButton rbResposta1, rbResposta2, rbResposta3;
    int respostaCerta = R.id.rbResposta1;
    RadioGroup rgRespostas;
    int pontos = 0;
    private AlertDialog alerta;

    private void confirmacao() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Confirmação");
        //define a mensagem
        builder.setMessage("Tem certeza que deseja finalizar o quiz?");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(QuizActivity.this, RespostaActivity.class);
                intent.putExtra("pontos", pontos);
                startActivity(intent);
                finish();

                //Toast.makeText(QuizActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
               // Toast.makeText(QuizActivity.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    List<Questoes> questoes = new ArrayList<Questoes>(){
        {
            add(new Questoes("Onde se concentrava a força de Sansão?", R.id.rbResposta2, "Barba", "Tranças", "Vestes"));
            add(new Questoes("Quem era o pai de José?", R.id.rbResposta3, "Abraão", "Isaque", "Jacó"));
            add(new Questoes("Porque Adão e Eva foram expulsos do Jardim do Edén?", R.id.rbResposta2, "Porque comeu a maçã", "Desobediência", "Mentira"));
            add(new Questoes("Quem foi com Moises para o Egito para dar liberdade ao povo Hebreu ?", R.id.rbResposta2, "Miriam", "Arão", "Josué"));
            add(new Questoes("Quais são alguns dos livros dos profetas menores? ?", R.id.rbResposta1, "Oséias, Joel, Amós, Obadias", "Salmos, Gênesis, Matheus", "Apocalipse, Judas, Hebreus"));
            add(new Questoes("Quem foram os Patriarcas ?", R.id.rbResposta1, "Abraão, Isaque e Jacó", "Moisés,Elias,Elizeu", "Josué, Davi,Salomão"));
            add(new Questoes("Qual são os nomes de alguns dos Apóstolos que andaram com Jesus.", R.id.rbResposta1, "Pedro, Tiago, Filipe", "Moisés, Abraão, Isaque", "Noé, Jeremias, Mateus"));
            add(new Questoes("Quantos livros tem a Bíblia no Velho Testamento e no Novo Testamento ?", R.id.rbResposta3, "60 Livros, 30 Velho Testamento e 30 Novo Testamento", "66 Livros, 27 Velho Testamento e 39 Novo Testamento", "66 Livros, 39 Velho Testamento e 27 Novo Testamento"));
            add(new Questoes("Quantos capítulos tem o livro de Ezequiel ?", R.id.rbResposta1, "48 Capítulos", "54 Capítulos", "150 Capítulos"));
            add(new Questoes("Qual foi a pessoa que começou a escrever o livro de Jeremias ?", R.id.rbResposta1, "Baruque, Jr. 45:1 e Jeremias reescreveu", "Tiago e Jeremias reescreveu", "Davi e Jeremias reescreveu"));
            add(new Questoes("Quais são os livros do Pentateuco?", R.id.rbResposta1, "Gênesis, Êxodo, Levítico, Números e Deuteronômio", "Gênesis, Êxodo, Ester, Números e Deuteronômio", "Josué, Juizes, Reis, Crônicas, Ester"));
            add(new Questoes("Quem foram os três primeiro reis de Israel ?", R.id.rbResposta1, " Saul, Davi e Salomão", " Samuel, Davi e Salomão", "Samuel, Saul, Davi"));
            add(new Questoes("Qual foi o homem no velho testamento que teve  três ministérios ?", R.id.rbResposta2, "Ananias foi profeta, sacerdote e juiz", "Samuel foi profeta, sacerdote e juiz", "Jeremias foi profeta, sacerdote e juiz"));
            add(new Questoes("Quem foram os três homens mais fiéis da Bíblia ?", R.id.rbResposta3, "Noé, Davi e Jó", "Davi, Daniel e Jó", "Noé, Daniel e Jó"));
            add(new Questoes("Qual o maior Livro da Bíblia e quantos capítulos ?", R.id.rbResposta2, "Apocalipse e tem 150 capítulos", "Salmos e tem 150 capítulos", "Salmos e tem 119 capítulos"));
            add(new Questoes("Quem foi o profeta que andou nu e descalço ?", R.id.rbResposta2, "Jeremias, Jr. 20:2 e 3", "Isaias, Is. 20:2 e 3", "Ezequias, Is. 20:2 e 3"));
            add(new Questoes("Qual o nome das esposas de Abraão, Isaque e Jacó ?", R.id.rbResposta3, "Miriam, Sara, Noemi", "Sara, Rebeca e Rute", "Sara, Rebeca e Raquel"));
            add(new Questoes("O que está escrito em Mateus 1:1 ?", R.id.rbResposta1, "Livro da genealogia de Jesus Cristo, filho de Davi, filho de Abraão", "Sacrificio de Jesus", "Primeiro milagre de Jesus"));
            add(new Questoes("Quantos anos tinha Jesus quando foi morto e ressuscitado ?", R.id.rbResposta2, "32", "33", "31"));
            add(new Questoes("Tinha um irmão gêmeo que me vendeu seu direito a ser abençoado por nosso pai. Quem sou eu ?", R.id.rbResposta1, "Jacó", "Ismael", "Isaque"));
            add(new Questoes("Por trezentos anos andei com Deus. Quem sou eu ?", R.id.rbResposta2, "Moises", "Enoque", "Abraão"));
            add(new Questoes("Reconstruí os muros de Jerusalém em 52 dias. Quem sou eu ?", R.id.rbResposta1, "Neemias", "Josué", "Davi"));
            add(new Questoes("Sou o único apóstolo que ficou cego. Quem sou eu ?", R.id.rbResposta2, "Jeremias", "Paulo", "Saulo"));
            add(new Questoes("Nas águas fui levado, no império fui criado e no deserto fui casado. Quem sou eu ?", R.id.rbResposta2, "Jacó", "Moisés", "Jonas"));
            add(new Questoes("Quem foi o profeta que casou com uma prostituta ?", R.id.rbResposta1, "Oséias", "Habacuque", "Sofonias"));
            add(new Questoes("Quem é o apostolo do Amor ?", R.id.rbResposta2, "Apostolo Ezequias", "Apostolo João", "Apostolo Jonas"));
            add(new Questoes("Qual era a profissão de Neemias no palácio ?", R.id.rbResposta1,"Copeiro do Rei", "Mordomo", "Motorista dos carros de guerra"));
            add(new Questoes("Onde está escrito a primeira profecia Messiânica ?", R.id.rbResposta1, "Em Gênesis 3:15", "Em Gênesis 4:15", "Em Gênesis 1:15"));
            add(new Questoes("O que está escrito na parte b de Romanos 8:31 ?", R.id.rbResposta2, "Sem fé é impossivel agradar a Deus", "Se Deus é por nós quem será contra nós?", "O salário do pecado é a morte."));
            add(new Questoes("O que está escrito em Mateus 6:9-13 ?", R.id.rbResposta2, "Milagre dos 5 paes e 3 peixinhos", "A oração modelo", "Milagre da água transformando em vinho"));
            add(new Questoes("Qual é a principal mensagem de Isaias 53 ?", R.id.rbResposta1, "Profecia acerca do Messias", "Profecia acerca da prosperidade", "Profecia acerca do jejum"));
            add(new Questoes("Quem escreveu o Salmo 90 ?", R.id.rbResposta2, "Davi", "Moisés", "Salomão"));
            add(new Questoes("Quem escreveu o Livro de Salmos em sua maioria ?", R.id.rbResposta2, "Moisés", "Davi", "Salomão"));
            add(new Questoes("Que voto tinha Sansão antes de perder a força ?", R.id.rbResposta1, "O voto de Nazireu", "O voto de Hebreus", "O voto de Cananeus"));
            add(new Questoes("Qual foi o profeta que escreveu sobre o atalaia ?", R.id.rbResposta2, "O profeta Isaías nos capitulos 3 e 33", "O profeta Ezequiel nos capitulos 3 e 33", "O profeta Malaquias nos capitulos 3 e 33"));
            add(new Questoes("Quais são os Evangelhos ?", R.id.rbResposta1, "Mateus, Marcos, Lucas e João", "I Corintios, II Corintios,Efésios", "Gênesis, Êxodo, Deuteronômio"));
            add(new Questoes("Quem escreveu o Livro do Apocalipse ?", R.id.rbResposta2, "Apóstolo Judas", "Apóstolo João", "Apóstolo Paulo"));
            add(new Questoes("Quem foi o imperador da Babilônia ?", R.id.rbResposta3, "Josafá", "Acabe", "Nabucodonosor"));
            add(new Questoes("Quanto tempo Israel ficou cativo no Egito ?", R.id.rbResposta2, "420 anos", "430 anos", "438 anos"));
            add(new Questoes("Quantos anos formaram o “tempo de silêncio” entre o novo e o velho testamento ?", R.id.rbResposta1, "430 anos", "330 anos", "2000 anos"));
            add(new Questoes("Qual era a função de Arão irmão de Moisés ?", R.id.rbResposta1, "Ele era sacerdote", "Ele era profeta", "Ele era guerreiro"));
            add(new Questoes("A quem Deus revelou os dez mandamentos ?", R.id.rbResposta1, "Moises", "Abraão", "Josué"));
            add(new Questoes("Quem mais escreveu Livros Bíblicos ?", R.id.rbResposta2, "O Apóstolo Neemias (15 Cartas)", "O Apóstolo Paulo (13 Cartas)", "O Apóstolo Pedro (13 Cartas)"));
            add(new Questoes("O que significa Gênesis ?", R.id.rbResposta1, "Começo ou inicio", "Criação", "Sem forma e vazio"));
            add(new Questoes("Quem apareceu no monte com Jesus ?", R.id.rbResposta2, "Davi e Elias", "Moisés e Elias", "Josué e Elias"));
            add(new Questoes("Quem era o rei judeu na época de Jesus ?", R.id.rbResposta2, "Rei Nabucodonosor", "Rei Herodes", "Rei Pilatos"));
            add(new Questoes("Que Apóstolo foi morto por Herodes ?", R.id.rbResposta2, "Apóstolo Paulo", "Apóstolo Tiago", "Apóstolo Jonas"));
            add(new Questoes("Como morreu Judas Iscariotes ?", R.id.rbResposta1, "Suicídio", "Pedradas", "Crucificado"));
            add(new Questoes("Qual são os únicos  livros na bíblia onde que não aparece o nome Deus ?", R.id.rbResposta1, "Ester e Cantares de Salomão", "Levíticos e Números", "Jonas e Miquéias"));
            add(new Questoes("Qual o nome mais comprido e estranho de toda a bíblia ?", R.id.rbResposta2, "Maersalalhasbas – filho de Isaias", "Sadraque – filho de Isaias", "Mesaque – filho de Isaias"));
            add(new Questoes("Qual era o nome da irmã de Moisés ?", R.id.rbResposta2, "Miriam", "Ester", "Rute"));

        }
    };

    private void carregarQuestao(){
        if(questoes.size() > 0) {
            Questoes q = questoes.remove(0);
            pergunta.setText(q.getPergunta());
            List<String> resposta = q.getRespostas();
            rbResposta1.setText(resposta.get(0));
            rbResposta2.setText(resposta.get(1));
            rbResposta3.setText(resposta.get(2));
            respostaCerta = q.getRespostaCerta();
            rgRespostas.setSelected(false);
        }
        else{ //acabaram as questões
            Intent intent = new Intent(this, RespostaActivity.class);
            intent.putExtra("pontos", pontos);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();

        pergunta = (TextView)findViewById(R.id.pergunta);
        rbResposta1 = (RadioButton)findViewById(R.id.rbResposta1);
        rbResposta2 = (RadioButton)findViewById(R.id.rbResposta2);
        rbResposta3 = (RadioButton)findViewById(R.id.rbResposta3);
        rgRespostas = (RadioGroup)findViewById(R.id.rgRespostas);
        carregarQuestao();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        carregarQuestao();
    }

    public void btnResponderOnClick(View v){
        RadioButton rb = (RadioButton)findViewById(rgRespostas.getCheckedRadioButtonId());
        Intent intent = new Intent(this, RespostaActivity.class);
        if(rgRespostas.getCheckedRadioButtonId() == respostaCerta) {
            intent.putExtra("acertou", true);
            pontos++;
        }
        else intent.putExtra("acertou", false);
        intent.putExtra("pontos", pontos);
        startActivity(intent);
        rb.setChecked(false);
    }

    public void btnFinalizarOnClick(View view) {
        confirmacao();
    }
}