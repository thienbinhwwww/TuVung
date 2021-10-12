package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnforeignlanguage.dao.VocabularyDao;
import com.example.learnforeignlanguage.mode.Vocabulary;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GameIIIActivity extends AppCompatActivity {

    TextView tv_poit,tv_d,tv_daA,tv_daB,tv_daC,tv_daD;
    ConstraintLayout ctLayout_daA,ctLayout_daB,ctLayout_daC,ctLayout_daD;

    VocabularyDao voDao;
    SharedPreferences sharedPre;
    Random random;
    TextToSpeech textToSpeech;
    Dialog dialogD;

    int idTopic,cauHoi=0,poit=0;
    List<Vocabulary> listVocabularies = new ArrayList<Vocabulary>();
    String s="";
    boolean daA,daB,daC,daD;
    ArrayList<Integer> listId = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_iiiactivity);

        anhXa();
        game();
    }

    private void game() {
        textToSpeech = new TextToSpeech(GameIIIActivity.this.getApplicationContext(), i1 -> {
            if(i1 == TextToSpeech.SUCCESS){
                // Lựa chọn ngôn ngữ
                int lang = textToSpeech.setLanguage(Locale.ENGLISH);
            }
        });
        listVocabularies = voDao.timKiemTopic(idTopic);
        listId = randomId(10,0,listVocabularies.size()-1);
        cauHoi();
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    public static ArrayList<Integer> randomId(int size, int min,int max) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (numbers.size() < size) {
            int random = getRandomInt(min, max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
    }

    private void cauHoi() {
        if(cauHoi<10){
            List<Vocabulary> listVocabulariesTemp = new ArrayList<>();
            tv_poit.setText(String.valueOf(cauHoi+1));
            daA=false;
            daB=false;
            daC=false;
            daD=false;
            s = listVocabularies.get(listId.get(cauHoi)).getVocabulary();
            phatAm();
            kTra(cauHoi);
            switch (random.nextInt(3)){
                case 0:
                    daA = true;
                    tv_daA.setText(s);
                    break;
                case 1:
                    daB = true;
                    tv_daB.setText(s);
                    break;
                case 2:
                    daC = true;
                    tv_daC.setText(s);
                    break;
                case 3:
                    daD = true;
                    tv_daD.setText(s);
                    break;
            }
            ctLayout_daA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(daA){
                        poit ++;
                        Toast.makeText(GameIIIActivity.this,"Bạn trả lời đúng",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(GameIIIActivity.this,"Bạn trả lời sai",Toast.LENGTH_LONG).show();
                    }
                    cauHoi();
                }
            });
            ctLayout_daB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(daB){
                        poit ++;
                        Toast.makeText(GameIIIActivity.this,"Bạn trả lời đúng",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(GameIIIActivity.this,"Bạn trả lời sai",Toast.LENGTH_LONG).show();
                    }
                    cauHoi();
                }
            });
            ctLayout_daC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(daC){
                        poit ++;
                        Toast.makeText(GameIIIActivity.this,"Bạn trả lời đúng",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(GameIIIActivity.this,"Bạn trả lời sai",Toast.LENGTH_LONG).show();
                    }
                    cauHoi();
                }
            });
            ctLayout_daD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(daD){
                        poit ++;
                        Toast.makeText(GameIIIActivity.this,"Bạn trả lời đúng",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(GameIIIActivity.this,"Bạn trả lời sai",Toast.LENGTH_LONG).show();
                    }
                    cauHoi();
                }
            });
            cauHoi++;
        }else {
            Dialog dialog = new Dialog(this);
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
        }
    }

    private void randomDapAn(ArrayList<Integer> listIdDa) {
        tv_daA.setText(listVocabularies.get(listIdDa.get(0)).getVocabulary());
        tv_daB.setText(listVocabularies.get(listIdDa.get(1)).getVocabulary());
        tv_daC.setText(listVocabularies.get(listIdDa.get(2)).getVocabulary());
        tv_daD.setText(listVocabularies.get(listIdDa.get(3)).getVocabulary());
    }

    private void kTra(int id) {
        ArrayList<Integer> listIdDa = randomId(4,0,listVocabularies.size()-1);
        for (int i=0;i<4;i++){
            if (listIdDa.get(i)==listId.get(id)){
                kTra(id);
            }
        }
        randomDapAn(listIdDa);
    }
    private void phatAm(){
        Log.d("Log", ""+s);
        // Chuyển đổi văn bản sang giọng nói
        textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null);
    }
    public void play(View view){
        phatAm();
    }
    private void anhXa() {
        tv_poit = findViewById(R.id.tv_gameIII_stt);
        ctLayout_daA = findViewById(R.id.ctlayout_gameIII_daA);
        ctLayout_daB = findViewById(R.id.ctlayout_gameIII_daB);
        ctLayout_daC = findViewById(R.id.ctlayout_gameIII_daC);
        ctLayout_daD = findViewById(R.id.ctlayout_gameIII_daD);
        tv_daA = findViewById(R.id.tv_gameIII_daA);
        tv_daB = findViewById(R.id.tv_gameIII_daB);
        tv_daC = findViewById(R.id.tv_gameIII_daC);
        tv_daD = findViewById(R.id.tv_gameIII_daD);

        voDao = new VocabularyDao(this);
        sharedPre = getSharedPreferences("phong",MODE_PRIVATE);
        random = new Random();
        idTopic = sharedPre.getInt("idTopic",0);

        dialogD = new Dialog(this);
        dialogD.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogD.setContentView(R.layout.layout_dialog_d);
        tv_d=dialogD.findViewById(R.id.tv_dialog_d);
    }
}