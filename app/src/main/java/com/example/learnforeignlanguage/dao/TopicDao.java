package com.example.learnforeignlanguage.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.learnforeignlanguage.database.Database;
import com.example.learnforeignlanguage.mode.Topic;


import java.util.ArrayList;
import java.util.List;

public class TopicDao {
    final String DATABASE_NAME = "data.sqlite";
    SQLiteDatabase sqLiteDatabase;
    Activity context;

    public TopicDao(Activity context) {
        this.context = context;
    }

    // Thêm Topic vào database
    public boolean addTopic(Topic topic){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // ghép cặp giá trị vào tên cột
        ContentValues contentValues = new ContentValues();
        contentValues.put("Topic",topic.getTopic());
        contentValues.put("Language",topic.getLanguage());

        // truy vấn
        long kq = sqLiteDatabase.insert("Topic", null, contentValues);

        // trả về kết quả truy vấn
        if (kq > 0){
            return true;
        } else{
            return false;
        }
    }
    // Thêm Topic tự do vào database
    public boolean addTopicTD(Topic topic){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // ghép cặp giá trị vào tên cột
        ContentValues contentValues = new ContentValues();
        contentValues.put("IdTopic",topic.getIdTopic());
        contentValues.put("Topic",topic.getTopic());
        contentValues.put("Language",topic.getLanguage());

        // truy vấn
        long kq = sqLiteDatabase.insert("Topic", null, contentValues);

        // trả về kết quả truy vấn
        if (kq > 0){
            return true;
        } else{
            return false;
        }
    }

    // update Topic vào database
    public boolean updateTopic(Topic topic){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // ghép cặp giá trị vào tên cột
        ContentValues contentValues = new ContentValues();
        contentValues.put("IdTopic",topic.getIdTopic());
        contentValues.put("Topic",topic.getTopic());
        contentValues.put("Language",topic.getLanguage());

        // truy vấn
        long kq = sqLiteDatabase.update("Topic", contentValues, "IdTopic ="+new int[]{topic.getIdTopic()},null);

        // trả về kết quả truy vấn
        if (kq > 0){
            return true;
        } else{
            return false;
        }
    }

    // Xóa topic trong database
    public boolean deleteTopic(int idTopic) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // truy vấn
        long kq = sqLiteDatabase.delete("Topic", "IdTopic =" + new int[]{idTopic}, null);

        // trả về kết quả truy vấn
        if (kq > 0) {
            return true;
        } else {
            return false;
        }
    }

    // Lấy dánh sách tất cả các topic trong database
    public List<Topic> getAllTopic(){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<Topic> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM Topic";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                // Lấy giá trị từ con trỏ
                int IDTopic = cursor.getInt(0);
                String topics = cursor.getString(1);
                String language = cursor.getString(2);

                // add vào Object
                Topic topic = new Topic();
                topic.setIdTopic(IDTopic);
                topic.setTopic(topics);
                topic.setLanguage(language);

                list.add(topic);
                cursor.moveToNext();
            }
        }
        return list;
    }

    // tìm kiếm topic theo idTopic trong database
    public List<Topic> timKiem(int idTopic) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<Topic> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM Topic WHERE IdTopic LIKE '" + idTopic + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                // Lấy giá trị từ con trỏ
                int IDTopic = cursor.getInt(0);
                String topics = cursor.getString(1);
                String language = cursor.getString(2);

                // add vào Object
                Topic topic = new Topic();
                topic.setIdTopic(IDTopic);
                topic.setTopic(topics);
                topic.setLanguage(language);

                list.add(topic);
                cursor.moveToNext();
            }
        }
        return list;
    }
}
