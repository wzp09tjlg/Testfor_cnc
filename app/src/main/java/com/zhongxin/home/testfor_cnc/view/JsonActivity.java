package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.bean.Person;
import com.zhongxin.home.testfor_cnc.utils.LogUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by Walter on 2015/7/25.
 */
public class JsonActivity extends Activity implements View.OnClickListener {

    private final String TAG = "JsonActivity";
    private final String jsonFilePath = "/sdcard/test.json";
    private Button mButtonWriteJson;
    private Button mButtonReadJson;
    private ArrayList<Person> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_json);
       findView();
        initView();
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.cnc_btn_write_json:
                LogUtil.LogE(TAG,"WRITE JSON:");
                writeJson();
                break;
            case R.id.cnc_btn_read_json:
                LogUtil.LogE(TAG,"READ JSON");
                try {
                    ArrayList<Person> persons = readJson();
                    for(Person person:persons){
                        LogUtil.LogE(TAG,"PERSON:"+person);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

    private void findView(){
        mButtonWriteJson = (Button) this.findViewById(R.id.cnc_btn_write_json);
        mButtonReadJson = (Button) this.findViewById(R.id.cnc_btn_read_json);
        mList = getData();
    }

    private void initView(){
        mButtonWriteJson.setOnClickListener(this);
        mButtonReadJson.setOnClickListener(this);
    }

    private ArrayList<Person> getData(){
        ArrayList<Person> data = new ArrayList<Person>();

        for(int i=0;i<10;i++){
            Person person = new Person.Builder().setId(i).setName("Walter"+i).setAge(i*123%78).setAddress("BEIJING"+i).build();
            data.add(person);
        }
        return data;
    }

    private void writePerson(JsonWriter writer,Person person){
        try{
            writer.beginObject();
            writer.name("ID").value(person.getId());
            writer.name("NAME").value(person.getName());
            writer.name("AGE").value(person.getAge());
            writer.name("ADDRESS").value(person.getAddress());
            writer.endObject();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void writeArrayPerson(JsonWriter writer,ArrayList<Person> persons){
       try{
           writer.beginArray();
           for (Person person:persons)
              writePerson(writer,person);
           writer.endArray();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    private void writeJsonStream(OutputStream os,ArrayList<Person> list){
        try {
            JsonWriter writer = new JsonWriter(new OutputStreamWriter(os,"utf-8"));
            writer.setIndent("   ");
            writer.setLenient(true);

            writeArrayPerson(writer,list);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void writeJson(){
        try {
            FileOutputStream os = new FileOutputStream(jsonFilePath);
            writeJsonStream(os,mList);
            LogUtil.LogE(TAG,"write Json success!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ArrayList<Person> readJson() throws  Exception{
        File file = new File(jsonFilePath);
        FileInputStream is = new FileInputStream(jsonFilePath);
        return readStream(is);
    }

    private ArrayList<Person> readStream(InputStream is)throws IOException {
        JsonReader reader =new  JsonReader(new InputStreamReader(is,"utf-8"));
        try{
            return readPersonArray(reader);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           reader.close();
        }
        return null;
    }

    private ArrayList<Person> readPersonArray(JsonReader reader){
        ArrayList<Person> list = new ArrayList<Person>();
        try {
            reader.beginArray();
            while (reader.hasNext())
            {
                list.add(readPerson(reader));
            }
            reader.endArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    private Person readPerson(JsonReader reader) throws  IOException{
       int id=0;
       String name="";
       int age = 0;
       String address="";
       reader.beginObject();
          while(reader.hasNext()){
              String field = reader.nextName();
              if(field.equals("ID")){
                  id = reader.nextInt();
              }else if(field.equals("NAME")){
                  name = reader.nextString();
              }else if(field.equals("AGE")){
                  age = reader.nextInt();
              }else if(field.equals("ADDRESS")){
                  address = reader.nextString();
              }else{
                  reader.skipValue();
              }
          }
       reader.endObject();
       return new Person.Builder().setId(id).setName(name).setAge(age).setAddress(address).build();
    }
}
