package com.example.learnforeignlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnforeignlanguage.dao.UserDao;
import com.example.learnforeignlanguage.mode.User;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    EditText edt_userName,edt_email,edt_phoneNumber,edt_password,edt_passwordRetype;
    UserDao userDao;
    List<User> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        anhXa();
    }

    private void anhXa() {
        edt_userName = findViewById(R.id.edt_signUp_userName);
        edt_email = findViewById(R.id.edt_signUp_email);
        edt_phoneNumber = findViewById(R.id.edt_signUp_phoneNumber);
        edt_password = findViewById(R.id.edt_signUp_password);
        edt_passwordRetype = findViewById(R.id.edt_signUp_passwordRetype);
        userDao = new UserDao(this);
        listUser = new ArrayList<>();
    }

    public void cancel(View view){
        finish();
    }

    public void signUp(View view){
        String userName = edt_userName.getText().toString();
        String email = edt_email.getText().toString();
        String phoneNumber = edt_phoneNumber.getText().toString();
        String password = edt_password.getText().toString();
        String passwordRetype = edt_passwordRetype.getText().toString();

        while (true){
            if(!(ck(userName)&&ck(email)&&ck(phoneNumber)&&ck(password)&&ck(passwordRetype))){
                Toast.makeText(this,"Không để trống ô nhập",Toast.LENGTH_LONG).show();
                break;
            }
            if (!password.equals(passwordRetype)){
                Toast.makeText(this,"Mật khẩu không khớp",Toast.LENGTH_LONG).show();
                break;
            }
            listUser = userDao.timUserName(edt_userName.getText().toString());
            if(!(listUser.size()==0)){
                Toast.makeText(this,"User name đã tồn tại",Toast.LENGTH_LONG).show();
                break;
            }
            User user = new User();
            user.setUserName(userName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setPassword(password);
            userDao.addUser(user);
            Toast.makeText(this,"Đăng ký thành công",Toast.LENGTH_LONG).show();
            finish();
            break;
        }

    }

    private boolean ck(String a){
        if (a.isEmpty()){
            return false;
        }
        return true;
    }
}