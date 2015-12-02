package com.zhongxin.home.testfor_cnc.bean;

/**
 * Created by Walter on 2015/10/15.
 */
public class PadKeyBean {
    private KeyType keyType;
    private String num;
    private int img;
    private String letter1;
    private String letter2;
    private String letter3;
    private String letter4;

    public PadKeyBean setKeyType(KeyType keyType) {
        this.keyType = keyType;
        return this;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public String getNum() {
        return num;
    }

    public int getImg() {
        return img;
    }

    public String getLetter1() {
        return letter1;
    }

    public String getLetter2() {
        return letter2;
    }

    public String getLetter3() {
        return letter3;
    }

    public String getLetter4() {
        return letter4;
    }

    public PadKeyBean setNum(String num) {
        this.num = num;
        return this;
    }

    public PadKeyBean setImg(int img) {
        this.img = img;
        return this;
    }

    public PadKeyBean setLetter1(String letter1) {
        this.letter1 = letter1;
        return this;
    }

    public PadKeyBean setLetter2(String letter2) {
        this.letter2 = letter2;
        return this;
    }

    public PadKeyBean setLetter3(String letter3) {
        this.letter3 = letter3;
        return this;
    }

    public PadKeyBean setLetter4(String letter4) {
        this.letter4 = letter4;
        return this;
    }

    public PadKeyBean(){}

    public int getLetterCount(){
        int count = 0;
        if(this.letter1 != null)
            count ++;
        if(this.letter2 != null)
            count ++;
        if(this.letter3 != null)
            count ++;
        if(this.letter4 != null)
            count ++;
        return count;
    }

    public String getLetters(){
        StringBuilder letters = new StringBuilder();
        if(letter1 != null)
            letters.append(letter1);
        if(letter2 != null)
            letters.append(letter2);
        if(letter3 != null)
            letters.append(letter3);
        if(letter4 != null)
            letters.append(letter4);
        return letters.toString();
    }

    public enum KeyType{
        INPUT,DELETE,CLEAR
    }
}
