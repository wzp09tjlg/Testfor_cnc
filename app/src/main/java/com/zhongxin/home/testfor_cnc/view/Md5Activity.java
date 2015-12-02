package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.api.checknum.ShowApiRequest;
import com.zhongxin.home.testfor_cnc.bean.EBean;
import com.zhongxin.home.testfor_cnc.utils.JsonParser;

import org.apache.http.Header;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Walter on 2015/10/8.
 */
public class Md5Activity extends Activity implements
     View.OnClickListener
{
    private final String TAG = "Md5Activity";
    //widget
    private Button mButtonEnc;
    private Button mButtonUnenc;
    //data
//    final AsyncHttpResponseHandler resHandler=new AsyncHttpResponseHandler(){
//        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable e) {
//            //做一些异常处理
//            e.printStackTrace();
//        }
//        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//            try {
//                long b=System.currentTimeMillis();
//                System.out.println("response is :" + new String(responseBody, "utf-8"));
//                //在此对返回内容做处理
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//
//        }};

    final AsyncHttpResponseHandler resHandler=new AsyncHttpResponseHandler(){
        //回调接口
        @Override
        public void onSuccess(int i, Header[] headers, byte[] bytes) {
            try {
                Log.e(TAG,""+headers.toString());
                String result =new String(bytes);
//                PhoneBean bean = new PhoneBean(JsonParser.getJsonParseResult(result, "showapi_res_body"));
                EBean bean = new EBean(JsonParser.getJsonParse(result,"showapi_res_body"));
                Log.e(TAG,"BEAN:" + bean);
                Log.d(TAG, "bytes:" + new String(bytes));
                //在此对返回内容做处理
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            throwable.printStackTrace();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_md5);
        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cnc_btn_md5_enc:
//                String str ="https://route.showapi.com/25-3?id=433130198904172917&showapi_appid=9196&showapi_timestamp=20151009115455";//"id433130198904172917showapi_appid9196showapi_timestamp20151009115455" ;//"https://route.showapi.com/6-1?num=13920809055&showapi_appid=9196&showapi_timestamp=20151008193121";//"num13920809055showapi_appid9196showapi_timestamp20151008193121";//"I am Walter.";
//                Toast.makeText(this,"before: " + str,Toast.LENGTH_LONG).show();
//                String result = getMD5(str);  //进行MD5加密的处理 获得MD5值
//                Toast.makeText(this,"after: " + result,Toast.LENGTH_LONG).show();

                new ShowApiRequest( "http://route.showapi.com/6-1", "9196", "41f935a8943441a69f2e9c79da52b942")
                        .setResponseHandler(resHandler)
                        .addTextPara("num","15210521539")
                        .post();
                break;
            case R.id.cnc_btn_md5_unenc:
                break;
        }
    }

    private void findView(){
        mButtonEnc = (Button) this.findViewById(R.id.cnc_btn_md5_enc);
        mButtonUnenc = (Button) this.findViewById(R.id.cnc_btn_md5_unenc);
    }

    private void initView(){
        mButtonEnc.setOnClickListener(this);
        mButtonUnenc.setOnClickListener(this);
    }

    private String getMD5Str(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        //16位加密，从第9位到25位
        return md5StrBuff.substring(8, 24).toString().toUpperCase();
    }

    public static String getMd5Value(String sSecret) {
        try {
            MessageDigest bmd5 = MessageDigest.getInstance("MD5");
            bmd5.update(sSecret.getBytes());
            int i;
            StringBuffer buf = new StringBuffer();
            byte[] b = bmd5.digest();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 生成md5
     * @param message
     * @return
     */
    public static String getMD5(String message) {
        String md5str = "";
        try {
            //1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            //2 将消息变成byte数组
            byte[] input = message.getBytes();

            //3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);

            //4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHex(buff);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    /**
     * 二进制转十六进制
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        //把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if(digital < 0) {
                digital += 256;
            }
            if(digital < 16){
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }
}
