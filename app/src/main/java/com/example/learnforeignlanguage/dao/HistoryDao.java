package com.example.learnforeignlanguage.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.learnforeignlanguage.database.Database;
import com.example.learnforeignlanguage.mode.History;


import java.util.ArrayList;
import java.util.List;

public class HistoryDao {
    final String DATABASE_NAME = "data.sqlite";
    SQLiteDatabase sqLiteDatabase;
    Activity context;

    public HistoryDao(Activity context) {
        this.context = context;
    }

    // thêm history vào database
    public boolean addHistory(History history){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // ghép cặp giá trị vào tên cột
        ContentValues contentValues = new ContentValues();
        contentValues.put("IdTopic",history.getIdTopic());
        contentValues.put("IdUser",history.getIdUser());
        contentValues.put("Time",history.getTime());

        // truy vấn
        long kq = sqLiteDatabase.insert("History", null, contentValues);

        // trả về kết quả truy vấn
        if (kq > 0){
            return true;
        } else{
            return false;
        }
    }


    // update history vào database
    public boolean updateHistory(History history){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // ghép cặp giá trị vào tên cột
        ContentValues contentValues = new ContentValues();
        contentValues.put("IdHistory",history.getIdHistory());
        contentValues.put("IdTopic",history.getIdTopic());
        contentValues.put("IdUser",history.getIdUser());
        contentValues.put("Time",history.getTime());

        // truy vấn
        long kq = sqLiteDatabase.update("History", contentValues, "IdHistory ="+new int[]{history.getIdHistory()},null);

        // trả về kết quả truy vấn
        if (kq > 0){
            return true;
        } else{
            return false;
        }
    }

    // xóa history trong database
    public boolean deleteHistory(int idHistory) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // truy vấn
        long kq = sqLiteDatabase.delete("History", "IdHistory =" + new int[]{idHistory}, null);

        // trả về kết quả truy vấn
        if (kq > 0) {
            return true;
        } else {
            return false;
        }
    }

    // lấy danh sách tất cả trong bảng history
    public List<History> getAllHistory(){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<History> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM History";

        // đưa các thành phần truy vấn được vào list
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                // Lấy giá trị từ con trỏ
                int IDHistory = cursor.getInt(0);
                int IDTopic = cursor.getInt(1);
                int IDUser = cursor.getInt(2);
                String time = cursor.getString(3);

                // add vào Object
                History history = new History();
                history.setIdHistory(IDHistory);
                history.setIdTopic(IDTopic);
                history.setIdUser(IDUser);
                history.setTime(time);

                list.add(history);
                cursor.moveToNext();
            }
        }
        return list;
    }

    // Tìm kiếm history theo idHistory trong database
    public List<History> timKiem(int idHistory) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<History> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM History WHERE IdHistory LIKE '" + idHistory + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                // Lấy giá trị từ con trỏ
                int IDHistory = cursor.getInt(0);
                int IDTopic = cursor.getInt(1);
                int IDUser = cursor.getInt(2);
                String time = cursor.getString(3);

                // add vào Object
                History history = new History();
                history.setIdHistory(IDHistory);
                history.setIdTopic(IDTopic);
                history.setIdUser(IDUser);
                history.setTime(time);

                list.add(history);
                cursor.moveToNext();
            }
        }
        return list;
    }

    // Tìm kiếm lịch sử người dùng
    public List<History> timKiemUs(int idUser) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<History> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM History WHERE IdUser LIKE '" + idUser + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                // Lấy giá trị từ con trỏ
                int IDHistory = cursor.getInt(0);
                int IDTopic = cursor.getInt(1);
                int IDUser = cursor.getInt(2);
                String time = cursor.getString(3);

                // add vào Object
                History history = new History();
                history.setIdHistory(IDHistory);
                history.setIdTopic(IDTopic);
                history.setIdUser(IDUser);
                history.setTime(time);

                list.add(history);
                cursor.moveToNext();
            }
        }
        return list;
    }
}
