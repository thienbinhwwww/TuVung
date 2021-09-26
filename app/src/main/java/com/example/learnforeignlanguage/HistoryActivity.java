package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.learnforeignlanguage.adapter.AdapterHistory;
import com.example.learnforeignlanguage.dao.HistoryDao;
import com.example.learnforeignlanguage.mode.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    GridView gridView;
    List<History> listHistory = new ArrayList<>();
    HistoryDao historyDao;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        anhXa();
        start();
    }


    private void start() {
        int idUser = sharedPreferences.getInt("idUser",0);
        listHistory = historyDao.timKiemUs(idUser);
        AdapterHistory adapterHistory = new AdapterHistory(listHistory,HistoryActivity.this);
        gridView.setAdapter(adapterHistory);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editor.putInt("idTopic", listHistory.get(i).getIdTopic());
                editor.commit();

                finish();
                Intent intent = new Intent(HistoryActivity.this,ListGameActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        gridView= findViewById(R.id.gridView_history);
        historyDao = new HistoryDao(this);
        sharedPreferences = getSharedPreferences("phong",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}