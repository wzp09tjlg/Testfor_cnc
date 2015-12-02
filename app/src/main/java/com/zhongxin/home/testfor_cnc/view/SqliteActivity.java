package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.utils.DbService;
import com.zhongxin.home.testfor_cnc.utils.LogUtil;

/**
 * Created by Walter on 2015/7/25.
 */
public class SqliteActivity extends Activity implements View.OnClickListener {

    private final String TAG = "SqliteActivity";
    private Button mButtonCreateDb;
    private Button mButtonInsert;
    private Button mButtonQuery;
    private DbService dbService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sqlite);

        findView();
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cnc_btn_create_database:
                break;
            case R.id.cnc_btn_insert_data:
                break;
            case R.id.cnc_btn_query_data:
                Cursor cursor = dbService.query("select * from test", null);
                cursor.moveToFirst();
                while(!cursor.isLast()) {
                    LogUtil.LogE(TAG, "id:" + cursor.getInt(0) + "   name:" + cursor.getString(1));
                    cursor.moveToNext();
                }
                cursor.close();
                break;
        }
    }

    private void findView(){
        mButtonCreateDb = (Button) this.findViewById(R.id.cnc_btn_create_database);
        mButtonInsert = (Button) this.findViewById(R.id.cnc_btn_insert_data);
        mButtonQuery = (Button) this.findViewById(R.id.cnc_btn_query_data);
        dbService = new DbService(this);
    }

    private void initView(){
        mButtonCreateDb.setOnClickListener(this);
        mButtonInsert.setOnClickListener(this);
        mButtonQuery.setOnClickListener(this);
    }
}
