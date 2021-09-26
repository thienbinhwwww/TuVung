package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.GridView;

import com.example.learnforeignlanguage.adapter.AdapterVocabulary;
import com.example.learnforeignlanguage.dao.VocabularyDao;
import com.example.learnforeignlanguage.mode.Vocabulary;

import java.util.ArrayList;
import java.util.List;

public class ListVocabularyActivity extends AppCompatActivity {
    GridView gridViewVocabulary;
    SharedPreferences sharedPreferences;
    VocabularyDao vocabularyDao;
    List<Vocabulary> listVocabulary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vocabulary);

        anhXa();

        start();
    }

    private void start() {
        listVocabulary = vocabularyDao.timKiemTopic(sharedPreferences.getInt("idTopic",0));

        AdapterVocabulary adapterVocabulary = new AdapterVocabulary(listVocabulary,this);
        gridViewVocabulary.setAdapter(adapterVocabulary);
    }

    private void anhXa() {
        gridViewVocabulary = findViewById(R.id.gridView_listVocabulary);
        sharedPreferences = getSharedPreferences("phong",MODE_PRIVATE);

        vocabularyDao = new VocabularyDao(this);
        listVocabulary = new ArrayList<>();
    }
}