package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.learnforeignlanguage.dao.UserDao;
import com.example.learnforeignlanguage.mode.User;

import java.util.ArrayList;
import java.util.List;

public class UsesActivity extends AppCompatActivity {
    TextView tv_userName,tv_email,tv_phoneNumber;
    SharedPreferences sharedPreferences;
    UserDao userDao;
    List<User> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uses);

        anhXa();
        start();
    }

    private void start() {
        String user = sharedPreferences.getString("userName","");
        list = userDao.timUserName(user);
        tv_userName.setText(list.get(0).getUserName());
        tv_email.setText(list.get(0).getEmail());
        tv_phoneNumber.setText(list.get(0).getPhoneNumber());
    }

    private void anhXa() {
        tv_userName = findViewById(R.id.tv_user_userName);
        tv_email = findViewById(R.id.tv_user_email);
        tv_phoneNumber = findViewById(R.id.tv_user_phoneNumber);
        sharedPreferences =getSharedPreferences("phong",MODE_PRIVATE);
        userDao = new UserDao(this);
        list = new ArrayList<>();
    }

    public void cancel(View view){
        finish();
    }
    public void logOut(View view){
        Intent intent = new Intent(UsesActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    public void history(View view){
        Intent intent = new Intent(UsesActivity.this,HistoryActivity.class);
        startActivity(intent);
    }
}