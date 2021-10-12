package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
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

public class GameIVActivity extends AppCompatActivity {

    TextView tv_cauHoi,tv_dapan,tv_d;
    ConstraintLayout ctLayout_tich,ctLayout_x;

    VocabularyDao voDao;
    SharedPreferences sharedPre;
    Random random;
    TextToSpeech textToSpeech;
    Dialog dialogD;
    Context context;

    int idTopic,cauHoi=0,poit=0;
    List<Vocabulary> listVocabularies = new ArrayList<Vocabulary>();
    String s="",dapan;
    boolean daA,daB,daC,daD;
    ArrayList<Integer> listId = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_ivactivity);

        anhXa();
        game();
    }

    private void game() {
        textToSpeech = new TextToSpeech(GameIVActivity.this.getApplicationContext(), i1 -> {
            if(i1 == TextToSpeech.SUCCESS){
                // Lựa chọn ngôn ngữ
                int lang = textToSpeech.setLanguage(Locale.ENGLISH);
            }
        });
        listVocabularies = voDao.timKiemTopic(idTopic);
        listId = randomId(10,0,listVocabularies.size()-1);
        cauHoi();
    }

    private void cauHoi() {
        if(cauHoi<10){
            tv_dapan.setText("");
            tv_cauHoi.setText(String.valueOf(cauHoi+1));
            s = listVocabularies.get(listId.get(cauHoi)).getVocabulary();
            boolean kTra = kTra(cauHoi);

            ctLayout_tich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (kTra){
                        poit ++;
                        Toast.makeText(context,"Bạn trả lời đúng",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(context,"Bạn trả lời sai",Toast.LENGTH_LONG).show();
                    }
                    cauHoi();
                }
            });

            ctLayout_x.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (kTra){
                        Toast.makeText(context,"Bạn trả lời sai",Toast.LENGTH_LONG).show();
                    }else {
                        poit ++;
                        Toast.makeText(context,"Bạn trả lời đúng",Toast.LENGTH_LONG).show();
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
    private void phatAm(){
        Log.d("Log", ""+s);
        // Chuyển đổi văn bản sang giọng nói
        tv_dapan.setText(dapan);
        textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null);
    }
    public void play(View view){
        phatAm();
    }
    private static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    private void randomDapAn(ArrayList<Integer> listIdDa) {
        dapan = listVocabularies.get(listIdDa.get(0)).getVocabulary();
    }

    private boolean kTra(int id) {
        ArrayList<Integer> listIdDa = randomId(1,0,listVocabularies.size()-1);
        if (listIdDa.get(0)==listId.get(id)){
            kTra(id);
        }
        if(random.nextInt(2)==1){
            dapan=s;
            return true;
        }else {
            randomDapAn(listIdDa);
            return false;
        }
    }

    private void anhXa() {
        context = GameIVActivity.this;
        tv_cauHoi = findViewById(R.id.tv_gameIV_stt);
        tv_dapan = findViewById(R.id.tv_gameiv_dapan);
        ctLayout_tich = findViewById(R.id.conLayout_gameIV_tich);
        ctLayout_x = findViewById(R.id.conLayout_gameIV_x);

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