package com.zhongxin.home.testfor_cnc.bean;

/**
 * Created by Wu on 2015/10/10.
 */
public class EBean {
    private String areaCode;
    private String city;
    private String name;
    private String num;
    private String postCode;
    private String provCode;
    private int ret_code;
    private int type;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public EBean(){}

    public EBean(EBean bean){
        this.areaCode = bean.getAreaCode();
        this.city     = bean.getCity();
        this.name     = bean.getName();
        this.num      = bean.getNum();
        this.postCode = bean.getPostCode();
        this.provCode = bean.getProvCode();
        this.ret_code = bean.getRet_code();
        this.type     = bean.getType();
    }

    @Override
    public String toString() {
        return "[areaCode:"+areaCode+",city:"+city+",name:"+name+",num:"+num+",postCode:"+postCode+",provCode:"+provCode+",ret_code:"+ret_code+",type:"+type+"]";
    }
}
