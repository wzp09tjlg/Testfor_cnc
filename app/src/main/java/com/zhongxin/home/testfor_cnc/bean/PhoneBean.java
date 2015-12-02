package com.zhongxin.home.testfor_cnc.bean;

/**
 * Created by Wu on 2015/10/9.
 */
public class PhoneBean {
    private String proc;
    private String city;
    private String name;
    private int    num;
    private int provCode;
    private int type;//1为移动 2为电信 3为联通

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getProvCode() {
        return provCode;
    }

    public void setProvCode(int provCode) {
        this.provCode = provCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public PhoneBean(){}

    public PhoneBean(PhoneBean bean){
        this.proc = bean.getProc();
        this.city = bean.getCity();
        this.name = bean.getName();
        this.num = bean.getNum();
        this.provCode = bean.getProvCode();
        this.type = bean.getType();
    }
}
