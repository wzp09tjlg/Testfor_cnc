package com.zhongxin.home.testfor_cnc.bean;

/**
 * Created by Walter on 2015/10/10.
 */
public class MapBean {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapBean(){}

    public MapBean(MapBean bean){
        this.code = bean.getCode();
        this.name = bean.getName();
    }

    public MapBean(String code,String name){
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[code:"+code+",name:"+name+"]";
    }
}
