package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        AnhXa();
        start();
    }

    private void start() {
        String user = sharedPreferences.getString("userName","");
        TextView tv_userName = findViewById(R.id.tv_menu_user);
        tv_userName.setText(user);
    }

    //Ánh xạ các biến
    private void AnhXa() {
        sharedPreferences =getSharedPreferences("phong",MODE_PRIVATE);
    }

//    Ân vào phần biểu tượng người dùng
    public void clickUser(View view){
        Intent intent = new Intent(MenuActivity.this,UsesActivity.class);
        startActivity(intent);
    }

//    Chức năng bài học chủ đề
    public void baiHocChuDe(View view){
        Intent intent = new Intent(MenuActivity.this, TopicActivity.class);
        startActivity(intent);
    }

//    Chức năng bài học tự chọn
    public void  baiHocTuChon(View view){
        Intent intent = new Intent(MenuActivity.this,ElectiveActivity.class);
        startActivity(intent);
//        MediaPlayer mediaPlayer = MediaPlayer.create(this, Uri.parse("https://soundoftext.nyc3.digitaloceanspaces.com/24dd8160-c7d4-11e7-9df0-2f554923557b.mp3"));
//        mediaPlayer.start();
    }

}