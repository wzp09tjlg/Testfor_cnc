package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.utils.LogUtil;

/**
 * Created by Walter on 2015/7/25.
 */
public class ContentProviderActivity extends Activity implements View.OnClickListener {

    private final String TAG = "ContentProviderActivity";
    private Button mButtonReadContract;
    private Button mButtonReadMessage;
    private ListView mList;
    private ListView mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_contentprovider);
        findView();
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cnc_btn_read_contract:
                break;
            case R.id.cnc_btn_read_message:
                break;
        }
    }

    private void findView(){
        mButtonReadContract = (Button) this.findViewById(R.id.cnc_btn_read_contract);
        mButtonReadMessage = (Button) this.findViewById(R.id.cnc_btn_read_message);
        mList = (ListView) this.findViewById(R.id.cnc_lv_data);
        mMessage = (ListView) this.findViewById(R.id.cnc_lv_message);
    }

    private void initView(){
        mButtonReadContract.setOnClickListener(this);
        mButtonReadMessage.setOnClickListener(this);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.item_contract,getData(),new String[]{ContactsContract.Contacts.DISPLAY_NAME},new int[]{R.id.cnc_tv_contract});
        mList.setAdapter(adapter);

//        SimpleCursorAdapter adapter1 = new SimpleCursorAdapter(this,R.layout.item_message,getMessages(),new String[]{"_id","address","body","date","type"},new int[]{R.id.cnc_tv_id,R.id.cnc_tv_address,R.id.cnc_tv_body,R.id.cnc_tv_date,R.id.cnc_tv_type});
//        mMessage.setAdapter(adapter);

        getMessages().moveToFirst();
        while(!getMessages().isLast()){
        LogUtil.LogE(TAG,"mesaage: id--> "+getMessages().getInt(0)+"   address--->"+getMessages().getString(1)+"  body-->"+getMessages().getString(2)+"  date-->"+getMessages().getString(3)+"  type-->"+getMessages().getString(4));
            getMessages().moveToNext();
        }
    }

    private Cursor getData(){
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        return cursor;
    }

    private Cursor getMessages(){
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor  = contentResolver.query(Uri.parse("content://sms/"),new String[]{"_id","address","body","date","type"},null,null,null);
        return  cursor;
    }
}
