package com.example.learnforeignlanguage.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.learnforeignlanguage.database.Database;
import com.example.learnforeignlanguage.mode.User;


import java.util.ArrayList;
import java.util.List;

public class UserDao {
    final String DATABASE_NAME = "data.sqlite";
    SQLiteDatabase sqLiteDatabase;
    Activity context;

    public UserDao(Activity context) {
        this.context = context;
    }

    // thêm user vào database
    public boolean addUser(User user){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // ghép cặp giá trị vào tên cột
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email",user.getEmail());
        contentValues.put("PhoneNumber",user.getPhoneNumber());
        contentValues.put("UserName",user.getUserName());
        contentValues.put("Password",user.getPassword());
        contentValues.put("Rank",user.getPassword());

        // truy vấn
        long kq = sqLiteDatabase.insert("User", null, contentValues);

        // trả về kết quả truy vấn
        if (kq > 0){
            return true;
        } else{
            return false;
        }
    }

    // update user vào database
    public boolean updateUser(User user){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // ghép cặp giá trị vào tên cột
        ContentValues contentValues = new ContentValues();
        contentValues.put("idUser",user.getIdUser());
        contentValues.put("Email",user.getEmail());
        contentValues.put("PhoneNumber",user.getPhoneNumber());
        contentValues.put("UserName",user.getUserName());
        contentValues.put("Password",user.getPassword());
        contentValues.put("Rank",user.getPassword());

        // truy vấn
        long kq = sqLiteDatabase.update("User", contentValues, "IdUser ="+new int[]{user.getIdUser()},null);

        // trả về kết quả truy vấn
        if (kq > 0){
            return true;
        } else{
            return false;
        }
    }

    // xóa user trong database
    public boolean deleteUser(int idUser) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // truy vấn
        long kq = sqLiteDatabase.delete("User", "IdUser =" + new int[]{idUser}, null);

        // trả về kết quả truy vấn
        if (kq > 0) {
            return true;
        } else {
            return false;
        }
    }

    // lấy danh sách tất cả trong bảng user
    public List<User> getAllUser(){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<User> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM User";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                // Lấy giá trị từ con trỏ
                int IDUser = cursor.getInt(0);
                String Email = cursor.getString(1);
                String PhoneNumber = cursor.getString(2);
                String UserName = cursor.getString(3);
                String Password = cursor.getString(4);
                String Rank = cursor.getString(5);

                // add vào Object
                User user = new User();
                user.setIdUser(IDUser);
                user.setEmail(Email);
                user.setPhoneNumber(PhoneNumber);
                user.setUserName(UserName);
                user.setPassword(Password);
                user.setRank(Rank);

                list.add(user);
                cursor.moveToNext();
            }
        }
        return list;
    }

    // tìm kiếm user theo id trong database
    public List<User> timKiem(int idUser) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<User> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM User WHERE IdUser LIKE '" + idUser + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                // Lấy giá trị từ con trỏ
                int IDUser = cursor.getInt(0);
                String Email = cursor.getString(1);
                String PhoneNumber = cursor.getString(2);
                String UserName = cursor.getString(3);
                String Password = cursor.getString(4);
                String Rank = cursor.getString(5);

                // add vào Object
                User user = new User();
                user.setIdUser(IDUser);
                user.setEmail(Email);
                user.setPhoneNumber(PhoneNumber);
                user.setUserName(UserName);
                user.setPassword(Password);
                user.setRank(Rank);

                list.add(user);
                cursor.moveToNext();
            }
        }
        return list;
    }

    // tim kiếm user theo userName
    public List<User> timUserName(String userName){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<User> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM User WHERE UserName LIKE '" + userName + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                // Lấy giá trị từ con trỏ
                int IDUser = cursor.getInt(0);
                String Email = cursor.getString(1);
                String PhoneNumber = cursor.getString(2);
                String UserName = cursor.getString(3);
                String Password = cursor.getString(4);
                String Rank = cursor.getString(5);

                // add vào Object
                User user = new User();
                user.setIdUser(IDUser);
                user.setEmail(Email);
                user.setPhoneNumber(PhoneNumber);
                user.setUserName(UserName);
                user.setPassword(Password);
                user.setRank(Rank);

                list.add(user);
                cursor.moveToNext();
            }
        }
        return list;
    }
}
