package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.learnforeignlanguage.dao.HistoryDao;
import com.example.learnforeignlanguage.mode.History;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListGameActivity extends AppCompatActivity {
    HistoryDao historyDao;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_game);
    }

    public void gameI(View view){
        createHistory();
        finish();
        Intent intent = new Intent(ListGameActivity.this,GameIActivity.class);
        startActivity(intent);
    }

    public void gameII(View view){
        createHistory();
        finish();
        Intent intent = new Intent(ListGameActivity.this,GameIIActivity.class);
        startActivity(intent);
    }

    public void gameIII(View view){
        createHistory();
        finish();
        Intent intent = new Intent(ListGameActivity.this,GameIIIActivity.class);
        startActivity(intent);
    }
    public void gameIV(View view){
        createHistory();
        finish();
        Intent intent = new Intent(ListGameActivity.this,GameIVActivity.class);
        startActivity(intent);
    }
    public void listVocabulary(View view){
        createHistory();
        finish();
        Intent intent = new Intent(ListGameActivity.this,ListVocabularyActivity.class);
        startActivity(intent);
    }

    void createHistory(){
        int idHistory=0;
        historyDao = new HistoryDao(this);
        sharedPreferences =getSharedPreferences("phong",MODE_PRIVATE);
        int idTopic = sharedPreferences.getInt("idTopic",0);
        int idUser = sharedPreferences.getInt("idUser",0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateandTime = sdf.format(new Date());

        History history = new History();
        history.setIdTopic(idTopic);
        history.setIdUser(idUser);
        history.setTime(currentDateandTime);
        historyDao.addHistory(history);
    }
}