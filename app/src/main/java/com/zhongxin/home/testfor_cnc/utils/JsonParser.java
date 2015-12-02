package com.zhongxin.home.testfor_cnc.utils;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zhongxin.home.testfor_cnc.bean.EBean;
import com.zhongxin.home.testfor_cnc.bean.MapBean;
import com.zhongxin.home.testfor_cnc.bean.PhoneBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Wu on 2015/9/1.
 */
public  class JsonParser {
    private static final String TAG = "JsonParser";

    public static EBean getJsonParse(String json,String key){  //获取当个bean
        if(json==null||key==null) return null;
        EBean bean = new EBean();
        JsonObject obj = new com.google.gson.JsonParser().parse(json).getAsJsonObject().getAsJsonObject(key);
        bean.setAreaCode(obj.get("areaCode").getAsString());
        bean.setCity(obj.get("city").getAsString());
        bean.setName(obj.get("name").getAsString());
        bean.setNum(obj.get("num").getAsString());
        bean.setPostCode(obj.get("postCode").getAsString());
        bean.setProvCode(obj.get("provCode").getAsString());
        bean.setRet_code(obj.get("ret_code").getAsInt());
        bean.setType(obj.get("type").getAsInt());
        return bean;
    }

    //获取list
    public static ArrayList<MapBean> getJsonParseList(String json,String key){
        if(json==null || key == null) return null;
        ArrayList<MapBean> list = new ArrayList<>();
        JsonObject obj = new com.google.gson.JsonParser().parse(json).getAsJsonObject().getAsJsonObject(key); //获取json的obj
        Iterator<?> iterator = obj.entrySet().iterator();//获取迭代器
        while(iterator.hasNext()){ //有下一个，就循环
         Map.Entry<String,JsonElement> entry = (Map.Entry<String,JsonElement>)iterator.next();
            MapBean bean = new MapBean();
            bean.setCode(entry.getKey().toString());
            bean.setName(entry.getValue().getAsString());
            list.add(bean);
        }
        return list;
    }
    //获取Map
    public static HashMap<String,List<MapBean>> getJsonParseMap(String json,String key){
        if(json == null || key == null) return null;
        HashMap<String,List<MapBean>> map = new HashMap<>();
        JsonObject obj = new com.google.gson.JsonParser().parse(json).getAsJsonObject().getAsJsonObject(key);
        Iterator<?> iterator = obj.entrySet().iterator();
        while(iterator.hasNext()){
          Map.Entry<String,JsonElement> entry = (Map.Entry<String,JsonElement>)iterator.next();
            List<MapBean> list = new ArrayList<>();
            JsonArray array = entry.getValue().getAsJsonArray();
            for(int i=0;i<array.size();i++){
                MapBean bean = new MapBean();
                bean.setCode(array.get(i).getAsJsonArray().get(0).getAsString());
                bean.setName(array.get(i).getAsJsonArray().get(1).getAsString());
                list.add(bean);
            }
            map.put(entry.getKey(),list);
        }
        return map;
    }

    public static PhoneBean getJsonParseResult(String json,String key){
       if(json == null || key == null) return null;//如果传入的值是空值，那么就不应该进入
        PhoneBean bean = new PhoneBean();
        JsonObject object = new com.google.gson.JsonParser().parse(json).getAsJsonObject().getAsJsonObject(key);
        Log.e(TAG,"object:" + object);
//        bean.setProc(object.get("proc").getAsString());
//        bean.setCity(object.get("city").getAsString());
//        bean.setName(object.get("name").getAsString());
//        bean.setProvCode(object.get("provCode").getAsInt());
//        bean.setType(object.get("type").getAsInt());

//        Iterator<?> iterator = object.entrySet().iterator();
//        while (iterator.hasNext()) {
//            @SuppressWarnings("unchecked")
//            Map.Entry<String, JsonElement> entry = (Map.Entry<String, JsonElement>) iterator
//                    .next();
//            bean.setProc(entry.getValue().toString());
//            bean.setCity(entry.getValue().toString());
//            bean.setName(entry.getValue().toString());
//            bean.setNum(entry.getValue().getAsInt());
//            bean.setProvCode(entry.getValue().getAsInt());
//            bean.setType(entry.getValue().getAsInt());
//        }
        return bean;
    }

//    public static ArrayList<String> package_list_name = new ArrayList<String>();
//    public static ArrayList<String> city_list_code = new ArrayList<String>();
//
//    public static ArrayList<PackageBean> getJSONParserResult(String json, String key) {
//        ArrayList<PackageBean> list = new ArrayList<PackageBean>();
//        JsonObject result = new com.google.gson.JsonParser().parse(json)
//                .getAsJsonObject().getAsJsonObject(key);
//
//        Iterator<?> iterator = result.entrySet().iterator();
//        while (iterator.hasNext()) {
//            @SuppressWarnings("unchecked")
//            Map.Entry<String, JsonElement> entry = (Map.Entry<String, JsonElement>) iterator
//                    .next();
//            PackageBean bean = new PackageBean();
//
//            bean.setName(entry.getValue().getAsString());
//            bean.setId(entry.getKey());
//            package_list_name.add(entry.getKey());
//            list.add(bean);
//        }
//        System.out.println(package_list_name.size());
//        return list;
//    }
//
//    public static HashMap<String, List<PackageBean>> getJSONParserResultArray(
//            String json, String key) {
//        HashMap<String, List<PackageBean>> hashMap = new HashMap<String, List<PackageBean>>();
//        JsonObject result = new com.google.gson.JsonParser().parse(json)
//                .getAsJsonObject().getAsJsonObject(key);
//
//        Iterator<?> iterator = result.entrySet().iterator();
//        while (iterator.hasNext()) {
//            @SuppressWarnings("unchecked")
//            Map.Entry<String, JsonElement> entry = (Map.Entry<String, JsonElement>) iterator
//                    .next();
//            List<PackageBean> list = new ArrayList<PackageBean>();
//            JsonArray array = entry.getValue().getAsJsonArray();
//            for (int i = 0; i < array.size(); i++) {
//                PackageBean bean = new PackageBean();
//                bean.setName(array.get(i).getAsJsonArray().get(0)
//                        .getAsString());
//                bean.setId(array.get(i).getAsJsonArray().get(1)
//                        .getAsString());
//                city_list_code.add(array.get(i).getAsJsonArray().get(1)
//                        .getAsString());
//                list.add(bean);
//            }
//            hashMap.put(entry.getKey(), list);
//        }
//        return hashMap;
//    }
}
