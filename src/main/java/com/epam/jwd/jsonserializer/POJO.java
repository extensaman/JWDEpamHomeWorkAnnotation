package com.epam.jwd.jsonserializer;

import java.util.Arrays;
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

    public POJO(int value, String text, int[] array, double aDouble, Map<Integer, String> map) {
        this.value = value;
        this.text = text;
        this.array = array;
        this.aDouble = aDouble;
        this.map = map;
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

    @Override
    public String toString() {
        return "POJO{" +
                "value=" + value +
                ", text='" + text + '\'' +
                ", array=" + Arrays.toString(array) +
                ", aDouble=" + aDouble +
                ", map=" + map +
                '}';
    }
}
