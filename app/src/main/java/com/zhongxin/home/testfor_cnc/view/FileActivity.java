package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.utils.LogUtil;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Walter on 2015/7/25.
 */
public class FileActivity extends Activity implements View.OnClickListener
{

    private final String TAG = "FileActivity";
    private Button mButtonReadFile;
    private Button mButtonWriteFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_file);
        findView();
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cnc_btn_read_file:  //针对写在内存中的文件
                try{
                    String file="";

                    InputStream is = openFileInput("file.txt");
                    int len=0;
                    byte[] buffer = new byte[100];
                    while((len = is.read(buffer))>0)
                    {
                        file = file +new String(buffer,0,len,"utf-8");
                    }

                    LogUtil.LogE(TAG,"FILE:"+file);
                    is.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.cnc_btn_write_file:
                try {
                    OutputStream os = openFileOutput("file.txt",Activity.MODE_PRIVATE);
                    String file="this is the test for save string into file.";
                    os.write(file.getBytes("utf-8"));
                    os.close();
                    LogUtil.LogE(TAG,"write success!");
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

    private void findView(){
      mButtonReadFile = (Button) this.findViewById(R.id.cnc_btn_read_file);
      mButtonWriteFile = (Button) this.findViewById(R.id.cnc_btn_write_file);
    }

    private void initView(){
        mButtonReadFile.setOnClickListener(this);
        mButtonWriteFile.setOnClickListener(this);
    }
}
