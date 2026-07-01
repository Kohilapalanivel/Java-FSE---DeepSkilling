
package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @Column(name = "op_qt_id")
    private int questionId;

    @Column(name = "op_score")
    private double score;

    @Column(name = "op_text")
    private String text;

    public Options() {
    }

    public Options(int id, int questionId, double score, String text) {
        this.id = id;
        this.questionId = questionId;
        this.score = score;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Option [id=" + id + ", text=" + text + ", score=" + score + "]";
    }
}
