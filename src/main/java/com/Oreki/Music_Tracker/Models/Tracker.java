package com.Oreki.Music_Tracker.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tracker {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="studentID")
    private int studentID;

    @Column(name="exeID")
    private int exeID;

    @Column(name="status")
    private String status;

    @Column(name="feedback")
    private String feedback;

    @Column(name="audioURL")
    private String audioURL;


    // get and set below

    public int getId() {
        return id;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getExeID() {
        return exeID;
    }

    public String getStatus() {
        return status;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setExeID(int exeID) {
        this.exeID = exeID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

}
