package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "at_date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "at_us_id")
    private User user;

    @Column(name = "at_score")
    private double score;
    @OneToMany(mappedBy = "attempt", fetch = FetchType.LAZY)
    private Set<AttemptQuestion> attemptQuestions;

    public Attempt() {}

    public Attempt(int id, Date date, User user, double score) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public Set<AttemptQuestion> getAttemptQuestions() {
        return attemptQuestions;
    }

    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions = attemptQuestions;
    }

    @Override
    public String toString() {
        return "Attempt [id=" + id + ", date=" + date + ", score=" + score + "]";
    }
}
