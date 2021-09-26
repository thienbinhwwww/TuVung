package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.learnforeignlanguage.adapter.AdapterTheme;
import com.example.learnforeignlanguage.dao.HistoryDao;
import com.example.learnforeignlanguage.dao.TopicDao;
import com.example.learnforeignlanguage.mode.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends AppCompatActivity {
    GridView gridView;
    List<Topic> listTopic = new ArrayList<>();
    TopicDao topicDao;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    HistoryDao historyDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        anhXa();
        start();



    }

    private void start() {
        listTopic = topicDao.getAllTopic();
        AdapterTheme adapterTheme = new AdapterTheme(listTopic,this);
        gridView.setAdapter(adapterTheme);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                editor.putInt("idTopic", listTopic.get(i).getIdTopic());
                editor.commit();

                finish();
                Intent intent = new Intent(TopicActivity.this,ListGameActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        gridView= findViewById(R.id.gridView_theme);
        topicDao = new TopicDao(this);
        historyDao = new HistoryDao(this);
        sharedPreferences = getSharedPreferences("phong",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}