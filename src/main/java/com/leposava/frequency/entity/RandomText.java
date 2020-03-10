package com.leposava.frequency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Time;

@Entity
public class RandomText {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @XmlTransient
    private int id;
    private String type;
    private int amount;
    private int number;
    private int number_max;
    private String format;
    private Time time;
    private String text_out;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber_max() {
        return number_max;
    }

    public void setNumber_max(int number_max) {
        this.number_max = number_max;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getText_out() {
        return text_out;
    }

    public void setText_out(String text_out) {
        this.text_out = text_out;
    }
}
