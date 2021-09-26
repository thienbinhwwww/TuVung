package com.example.learnforeignlanguage.mode;

public class Vocabulary {
    private int idVocabulary;
    private int idTopic;
    private String vocabulary;
    private String means;

    public Vocabulary() {
    }

    public Vocabulary(int idVocabulary, int idTopic, String vocabulary, String means) {
        this.idVocabulary = idVocabulary;
        this.vocabulary = vocabulary;
        this.means = means;
        this.idTopic = idTopic;
    }

    public int getIdVocabulary() {
        return idVocabulary;
    }

    public void setIdVocabulary(int idVocabulary) {
        this.idVocabulary = idVocabulary;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }
}
