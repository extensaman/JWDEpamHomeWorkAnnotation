package com.epam.jwd.jsonserializer.entity;

import com.epam.jwd.jsonserializer.service.annotation.Public;

import java.util.Date;
import java.util.Map;

public class POJO {
    @Public
    private int value;
    @Public
    private String text;
    @Public
    private int[] array;
    @Public
    private double aDouble;
    @Public
    private Map<Integer, String> map;
    @Public
    private Date date;

    public POJO(int value, String text, int[] array, double aDouble, Map<Integer, String> map, Date date) {
        this.value = value;
        this.text = text;
        this.array = array;
        this.aDouble = aDouble;
        this.map = map;
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
