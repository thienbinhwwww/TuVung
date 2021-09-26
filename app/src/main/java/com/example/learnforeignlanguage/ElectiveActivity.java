package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.learnforeignlanguage.adapter.AdapterVocabulary;
import com.example.learnforeignlanguage.dao.TopicDao;
import com.example.learnforeignlanguage.dao.VocabularyDao;
import com.example.learnforeignlanguage.mode.Topic;
import com.example.learnforeignlanguage.mode.Vocabulary;

import java.util.ArrayList;
import java.util.List;

public class ElectiveActivity extends AppCompatActivity {
    List<Vocabulary> listVocabulary;
    List<Topic> listTopic;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TopicDao topicDao;

    VocabularyDao vocabularyDao;
    boolean c1;
    EditText tv_vocabulary,tv_n;
    int idTopic=10;
    GridView gridViewVocabulary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elective);

        anhXa();
    }

    private void anhXa() {
        listVocabulary = new ArrayList<>();
        listTopic = new ArrayList<>();

        tv_vocabulary = findViewById(R.id.edt_add);
        tv_n = findViewById(R.id.edt_add_m);

        vocabularyDao = new VocabularyDao(this);
        topicDao = new TopicDao(this);

        c1 = true;
        sharedPreferences = getSharedPreferences("phong",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gridViewVocabulary=findViewById(R.id.gridView_newVocalody);
    }

    public void add(View view){
        if(idTopic==0) {
            while (true){
                if (topicDao.timKiem(idTopic).isEmpty()){
                    break;
                }else {
                    idTopic++;
                }
            }
            // Tạo topic mới
            Topic topic = new Topic();
            topic.setTopic("Chủ đề tự do");
            topic.setIdTopic(idTopic);
            topicDao.addTopicTD(topic);

            Vocabulary vocabulary = new Vocabulary();
            vocabulary.setVocabulary(tv_vocabulary.getText().toString());
            vocabulary.setMeans(tv_n.getText().toString());
            vocabulary.setIdTopic(idTopic);
            vocabularyDao.addVocabulary(vocabulary);
        }else {
            Vocabulary vocabulary = new Vocabulary();
            vocabulary.setVocabulary(tv_vocabulary.getText().toString());
            vocabulary.setMeans(tv_n.getText().toString());
            vocabulary.setIdTopic(idTopic);
            vocabularyDao.addVocabulary(vocabulary);

        }
        addAdapter(idTopic);
    }
    public void strat(View view){
        if(idTopic!=0) {
            Intent intent = new Intent(ElectiveActivity.this, ListGameActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Hãy thêm từ mới để bắt đầu", Toast.LENGTH_SHORT).show();
        }
    }



    public void addAdapter(int id){
        listVocabulary.clear();
        listVocabulary = vocabularyDao.timKiemTopic(idTopic);
        AdapterVocabulary adapterVocabulary = new AdapterVocabulary(listVocabulary,this);
        gridViewVocabulary.setAdapter(adapterVocabulary);
    }
}