package com.leposava.frequency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @XmlTransient
    private int id;
    private String freq_word;
    private int avg_paragraph_size;
    private long avg_paragraph_processing_time;
    private long total_processing_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFreq_word() {
        return freq_word;
    }

    public void setFreq_word(String freq_word) {
        this.freq_word = freq_word;
    }

    public int getAvg_paragraph_size() {
        return avg_paragraph_size;
    }

    public void setAvg_paragraph_size(int avg_paragraph_size) {
        this.avg_paragraph_size = avg_paragraph_size;
    }

    public long getAvg_paragraph_processing_time() {
        return avg_paragraph_processing_time;
    }

    public void setAvg_paragraph_processing_time(long avg_paragraph_processing_time) {
        this.avg_paragraph_processing_time = avg_paragraph_processing_time;
    }

    public long getTotal_processing_time() {
        return total_processing_time;
    }

    public void setTotal_processing_time(long total_processing_time) {
        this.total_processing_time = total_processing_time;
    }
}
