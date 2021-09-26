package com.example.learnforeignlanguage.mode;

public class Topic {
    private int idTopic;
    private String topic;
    private String language;

    public Topic() {
    }

    public Topic(int idTopic, String topic, String language) {
        this.idTopic = idTopic;
        this.topic = topic;
        this.language = language;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
