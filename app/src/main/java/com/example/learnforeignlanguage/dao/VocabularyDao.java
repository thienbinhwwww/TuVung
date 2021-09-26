package com.example.learnforeignlanguage.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.learnforeignlanguage.database.Database;
import com.example.learnforeignlanguage.mode.Vocabulary;


import java.util.ArrayList;
import java.util.List;

public class VocabularyDao {
    final String DATABASE_NAME = "data.sqlite";
    SQLiteDatabase sqLiteDatabase;
    Activity context;

    public VocabularyDao(Activity context) {
        this.context = context;
    }

    // thêm vocabulary vào database
    public boolean addVocabulary(Vocabulary vocabulary){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // ghép cặp giá trị vào tên cột
        ContentValues contentValues = new ContentValues();
        contentValues.put("IdTopic",vocabulary.getIdTopic());
        contentValues.put("Vocabulary",vocabulary.getVocabulary());
        contentValues.put("Means",vocabulary.getMeans());


        // truy vấn
        long kq = sqLiteDatabase.insert("Vocabulary", null, contentValues);

        // trả về kết quả truy vấn
        if (kq > 0){
            return true;
        } else{
            return false;
        }
    }

    // update vocabulary vào database
    public boolean updateVocabulary(Vocabulary vocabulary){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        // ghép cặp giá trị vào tên cột 2
        ContentValues contentValues = new ContentValues();
        contentValues.put("IdVocabulary",vocabulary.getIdVocabulary());
        contentValues.put("IdTopic",vocabulary.getIdTopic());
        contentValues.put("Vocabulary",vocabulary.getVocabulary());
        contentValues.put("Means",vocabulary.getMeans());

        // truy vấn
        long kq = sqLiteDatabase.update("Vocabulary", contentValues, "IdVocabulary ="+new int[]{vocabulary.getIdVocabulary()},null);

        // trả về kết quả truy vấn
        if (kq > 0){
            return true;
        } else{
            return false;
        }
    }

    // xóa vocabulary trong database
    public boolean deleteVocabulary(int idVocabulary) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);

        // truy vấn
        long kq = sqLiteDatabase.delete("Vocabulary", "IdVocabulary =" + new int[]{idVocabulary}, null);

        // trả về kết quả truy vấn
        if (kq > 0) {
            return true;
        } else {
            return false;
        }
    }

    // lấy danh sách tất cả trong bảng Vocabulary
    public List<Vocabulary> getAllVocabulary(){
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<Vocabulary> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM Vocabulary";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                // Lấy giá trị từ con trỏ
                int IDVocabulary = cursor.getInt(0);
                int IDTopic = cursor.getInt(1);
                String Vocabulary= cursor.getString(2);
                String Means = cursor.getString(3);

                // add vào Object
                Vocabulary vocabulary = new Vocabulary();
                vocabulary.setIdVocabulary(IDVocabulary);
                vocabulary.setVocabulary(Vocabulary);
                vocabulary.setMeans(Means);
                vocabulary.setIdTopic(IDTopic);

                list.add(vocabulary);
                cursor.moveToNext();
            }
        }
        return list;
    }
    // Tìm kiếm Vocabulary theo id trong database
    public List<Vocabulary> timKiem(int idVocabulary) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<Vocabulary> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM Vocabulary WHERE IdVocabulary LIKE '" + idVocabulary + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                // Lấy giá trị từ con trỏ
                int IDVocabulary = cursor.getInt(0);
                int IDTopic = cursor.getInt(1);
                String Vocabulary= cursor.getString(2);
                String Means = cursor.getString(3);

                // add vào Object
                Vocabulary vocabulary = new Vocabulary();
                vocabulary.setIdVocabulary(IDVocabulary);
                vocabulary.setVocabulary(Vocabulary);
                vocabulary.setMeans(Means);
                vocabulary.setIdTopic(IDTopic);

                list.add(vocabulary);
                cursor.moveToNext();
            }
        }
        return list;
    }

    public List<Vocabulary> timKiemTopic(int idTopic) {
        sqLiteDatabase = Database.initDatabase(context,DATABASE_NAME);
        List<Vocabulary> list = new ArrayList<>();

        // truy vấn trong database
        String sql = "SELECT * FROM Vocabulary WHERE IdTopic LIKE '" + idTopic + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        // đưa các thành phần truy vấn được vào list
        list.clear();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                // Lấy giá trị từ con trỏ
                int IDVocabulary = cursor.getInt(0);
                int IDTopic = cursor.getInt(1);
                String Vocabulary= cursor.getString(2);
                String Means = cursor.getString(3);

                // add vào Object
                Vocabulary vocabulary = new Vocabulary();
                vocabulary.setIdVocabulary(IDVocabulary);
                vocabulary.setVocabulary(Vocabulary);
                vocabulary.setMeans(Means);
                vocabulary.setIdTopic(IDTopic);

                list.add(vocabulary);
                cursor.moveToNext();
            }
        }
        return list;
    }
}
