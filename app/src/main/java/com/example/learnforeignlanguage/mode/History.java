package com.example.learnforeignlanguage.mode;

public class History {
    private int idHistory;
    private int idTopic;
    private int idUser;
    private String time;

    public History() {
    }

    public History(int idHistory, int idTopic, int idUser,String time) {
        this.idHistory = idHistory;
        this.idTopic = idTopic;
        this.idUser = idUser;
        this.time = time;
    }

    public int getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(int idHistory) {
        this.idHistory = idHistory;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
