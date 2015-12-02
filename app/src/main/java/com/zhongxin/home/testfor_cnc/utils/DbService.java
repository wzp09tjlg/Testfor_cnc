package com.zhongxin.home.testfor_cnc.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Walter on 2015/7/25.
 */
public class DbService extends SQLiteOpenHelper {
    private static final String DB_NAME = "MyDb.db";
    private static final int DB_VERSION = 1;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String sql = "CREATE TABLE [test]("+"[id] AUTOINC, [name] VARCHAR(20) NOT NULL ON CONFLICT FAIL , CONSTRAINT [sqlite_autoindex_test] PRIMARY KEY(id))";
       sqLiteDatabase.execSQL(sql);

        for(int i=0;i<10;i++){
            sqLiteDatabase.execSQL("insert into test(id,name) values(?,?)",new Object[]{i,"BEIJING"+i});
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

    public DbService(Context context){
       super(context,DB_NAME,null,DB_VERSION);
    }

    public Cursor query(String sql,String[] objs){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,objs);
        return cursor;
    }
}
