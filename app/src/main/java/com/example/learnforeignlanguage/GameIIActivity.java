package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnforeignlanguage.dao.VocabularyDao;
import com.example.learnforeignlanguage.mode.Vocabulary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameIIActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    VocabularyDao vocabularyDao;
    List<Vocabulary> listVocabulary;
    List<String> listMeans = new ArrayList<>();
    TextView btnA,btnB,btnC,btnD,tvVocabulary,tvGameIISTT;

    int poit=0;
    int temp=0;
    Random random = new Random();
    Dialog dialogD;
    TextView tv_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_i_i);

        //ánh xạ các biến
        anhXa();

        //Chạy chương trình
        strat();
    }

    private void strat() {

        createGame();
    }

    private void createGame() {
        listVocabulary = vocabularyDao.timKiemTopic(sharedPreferences.getInt("idTopic",0));
        listMeans.clear();
        for (int i=0;i<listVocabulary.size();i++){
            listMeans.add(listVocabulary.get(i).getMeans());
        }
        if(temp>=10){
            Dialog dialog = new Dialog(GameIIActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.layout_dialog_kq);
            TextView tv_poit = dialog.findViewById(R.id.tv_dialog_kq);
            tv_poit.setText(String.valueOf(poit));
            Button button = dialog.findViewById(R.id.btn_dialg_ok);
            dialog.show();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    finish();
                }
            });
        }else {
            switch (ramdom(temp)){
                case 0:
                    btnA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            poit++;
                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả lời đúng", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnC.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    break;
                case 1:
                    btnB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            poit++;
                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả lời đúng", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnC.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    break;
                case 2:
                    btnC.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            poit++;
                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả lời đúng", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    break;
                case 3:
                    btnD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            poit++;
                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả lời đúng", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnC.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    btnA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            temp++;
                            Toast.makeText(GameIIActivity.this, "Bạn trả sai rồi", Toast.LENGTH_SHORT).show();
                            createGame();
                        }
                    });
                    break;
            }
        }
    }

    public int ramdom(int i) {
        int id = random.nextInt(listVocabulary.size());
        tvGameIISTT.setText((i + 1) + "/10");
        int kt = random.nextInt(4);
        tvVocabulary.setText(listVocabulary.get(id).getVocabulary());
        List<String> listSt;
        switch (kt){
            case 0:
                btnA.setText(listVocabulary.get(id).getMeans());
                removeDA(listVocabulary.get(id).getMeans());
                listSt = new ArrayList<>();
                for (int j=0;j<3;j++){
                    int rand = random.nextInt(listMeans.size());
                    listSt.add(listMeans.get(rand));
                    removeDA(listMeans.get(rand));
                }
                btnB.setText(listSt.get(0));
                btnC.setText(listSt.get(1));
                btnD.setText(listSt.get(2));
                break;
            case 1:
                btnB.setText(listVocabulary.get(id).getMeans());
                removeDA(listVocabulary.get(id).getMeans());
                listSt = new ArrayList<>();
                for (int j=0;j<3;j++){
                    int rand = random.nextInt(listMeans.size());
                    listSt.add(listMeans.get(rand));
                    removeDA(listMeans.get(rand));
                }
                btnA.setText(listSt.get(0));
                btnC.setText(listSt.get(1));
                btnD.setText(listSt.get(2));
                break;
            case 2:
                btnC.setText(listVocabulary.get(id).getMeans());
                removeDA(listVocabulary.get(id).getMeans());
                listSt = new ArrayList<>();
                for (int j=0;j<3;j++){
                    int rand = random.nextInt(listMeans.size());
                    listSt.add(listMeans.get(rand));
                    removeDA(listMeans.get(rand));
                }
                btnA.setText(listSt.get(0));
                btnB.setText(listSt.get(1));
                btnD.setText(listSt.get(2));
                break;
            case 3:
                btnD.setText(listVocabulary.get(id).getMeans());
                removeDA(listVocabulary.get(id).getMeans());
                listSt = new ArrayList<>();
                for (int j=0;j<3;j++){
                    int rand = random.nextInt(listMeans.size());
                    listSt.add(listMeans.get(rand));
                    removeDA(listMeans.get(rand));
                }
                btnA.setText(listSt.get(0));
                btnB.setText(listSt.get(1));
                btnC.setText(listSt.get(2));
                break;
        }

 /*       if (kt==0) {

            tv_Means.setText(listVocabulary.get(id).getMeans());

        } else {
            int ii = random.nextInt(listMeans.size());
            tv_Vocabulary.setText(listVocabulary.get(id).getVocabulary());
            tv_Means.setText(listMeans.get(ii));

        }
  */
        return kt;
    }

    private void removeDA(String t){
        for (int j=0;j<listMeans.size();j++){
            if(listMeans.get(j).equals(t)){
                listMeans.remove(j);
            }
        }
    }

    private void anhXa() {
        btnA = findViewById(R.id.btn_gameiiA);
        btnB = findViewById(R.id.btn_gameiiB);
        btnC = findViewById(R.id.btn_gameiiC);
        btnD = findViewById(R.id.btn_gameiiD);
        tvGameIISTT = findViewById(R.id.tv_gameii_stt);
        tvVocabulary = findViewById(R.id.tv_gameii_vocabulary);
        vocabularyDao = new VocabularyDao(this);
        listVocabulary = new ArrayList<>();
        sharedPreferences =getSharedPreferences("phong",MODE_PRIVATE);
        dialogD = new Dialog(this);
        dialogD.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogD.setContentView(R.layout.layout_dialog_d);
        tv_d=dialogD.findViewById(R.id.tv_dialog_d);
    }
}