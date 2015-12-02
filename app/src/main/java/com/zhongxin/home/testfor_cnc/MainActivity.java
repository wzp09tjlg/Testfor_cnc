package com.zhongxin.home.testfor_cnc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.view.CheckIdActivity;
import com.zhongxin.home.testfor_cnc.view.CheckNumActivity;
import com.zhongxin.home.testfor_cnc.view.ContentProviderActivity;
import com.zhongxin.home.testfor_cnc.view.DialogActivity;
import com.zhongxin.home.testfor_cnc.view.EventBusActivity;
import com.zhongxin.home.testfor_cnc.view.HandlerActivity;
import com.zhongxin.home.testfor_cnc.view.JsonActivity;
import com.zhongxin.home.testfor_cnc.view.JsonXmlActivity;
import com.zhongxin.home.testfor_cnc.view.KeyPadActivity;
import com.zhongxin.home.testfor_cnc.view.LayoutActivity;
import com.zhongxin.home.testfor_cnc.view.Md5Activity;
import com.zhongxin.home.testfor_cnc.view.MyFragmentActivity;
import com.zhongxin.home.testfor_cnc.view.MyPlayerActivity;
import com.zhongxin.home.testfor_cnc.view.OtherApkActivity;
import com.zhongxin.home.testfor_cnc.view.PictureActivity;
import com.zhongxin.home.testfor_cnc.view.PopupWindowActivity;
import com.zhongxin.home.testfor_cnc.view.ReflectionActivity;
import com.zhongxin.home.testfor_cnc.view.ScollerCityActivity;
import com.zhongxin.home.testfor_cnc.view.SelfViewActivity;
import com.zhongxin.home.testfor_cnc.view.ServiceActivity;
import com.zhongxin.home.testfor_cnc.view.ShareprefenceNewActivity;
import com.zhongxin.home.testfor_cnc.view.SlidingActivity;
import com.zhongxin.home.testfor_cnc.view.SortActivity;
import com.zhongxin.home.testfor_cnc.view.SqliteActivity;
import com.zhongxin.home.testfor_cnc.view.SurfaceViewActivity;
import com.zhongxin.home.testfor_cnc.view.TimerActivity;
import com.zhongxin.home.testfor_cnc.view.ToastActivity;

import java.util.HashMap;


public class MainActivity extends Activity implements View.OnClickListener
{
    private final String TAG = "MainActivity";
    private Button mButtonShareprefence;
    private Button mButtonFile;
    private Button mButtonJson;
    private Button mButtonSqlite;
    private Button mButtonContentrovider;
    private Button mButtonService;
    private Button mButtonReflection;
    private Button mButtonFragment;
    private Button mButtonTimer;
    private Button mButtonPicture;
    private Button mButtonDialog;
    private Button mButtonCheckId;
    private Button mButtonScollerCity;
    private Button mButtonSlidingMenu;
    private Button mButtonCheckNumber;
    private Button mButtonSelfView;
    private Button mButtonSurfaceView;
    private Button mButtonSurface_new;
    private Button mButtonHandler;
    private Button mButtonPopupWindow;
    private Button mButtonEventBus;
    private Button mButtonLayout;
    private Button mButtonOtherApk;
    private Button mButtonMd5;
    private Button mButtonJsonXml;
    private Button mButtonSort;
    private Button mButtonKeyPad;
    private Button mButtonToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        findView();
        initView();
    }

    @Override
    public void onClick(View view) {
         switch(view.getId()){
             case R.id.cnc_btn_shareprefence:
//                 AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(
//                         this);
//                 dialogBuilder.setTitle(R.string.dialog_select_type);
//
//                 CharSequence[] menuItemArray = new CharSequence[] {
//                         this.getString(R.string.dialog_type_text),
//                         this.getString(R.string.dialog_type_audio),
//                         this.getString(R.string.dialog_type_video),
//                         this.getString(R.string.dialog_type_image) };
//                 dialogBuilder.setItems(menuItemArray,
//                         new DialogInterface.OnClickListener()
//                         {
//                             @Override
//                             public void onClick(DialogInterface dialog, int which)
//                             {
//                                 String selectType = "*/*";
//                                 switch (which)
//                                 {
//                                     case 0:
//                                         selectType = "text/plain";
//                                         break;
//                                     case 1:
//                                         selectType = "audio/*";
//                                         break;
//                                     case 2:
//                                         selectType = "video/*";
//                                         break;
//                                     case 3:
//                                         selectType = "image/*";
//                                         break;
//                                 }
//                                 Intent intent = new Intent();
//                                 // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                 intent.setAction(Intent.ACTION_VIEW);
//                                 intent.setDataAndType(
//                                         Uri.fromFile(new File("")),
//                                         selectType);
//                                 startActivity(intent);
//                             }
//                         });
//                 dialogBuilder.show();

                 Intent intentShareprefence = new Intent(MainActivity.this, ShareprefenceNewActivity.class);
                 startActivity(intentShareprefence);
                 break;
             case R.id.cnc_btn_file:
                 HashMap<Integer ,String> map1 = new HashMap<Integer, String>();
                 for(int i=0;i<10;i++){
                     map1.put(new Integer(i),"number"+i);
                 }
                 HashMap<Integer,String> map2 = new HashMap<Integer, String>();
                 map2.putAll(map1);
                 System.out.println("---------------------------------befoe");
                 for(int i= 0;i<map1.size();i++){
                     System.out.println(map1.get(new Integer(i)).toString());
                 }
                 map1.clear();
                 System.out.println("---------------------------------after");
                 for(int i= 0;i<map1.size();i++){
                     System.out.println(map1.get(new Integer(i)).toString());
                 }

                 System.out.println("---------------------------------befoe    map2:");
                 for(int i= 0;i<map2.size();i++){
                     System.out.println(map2.get(new Integer(i)).toString());
                 }
//                 Intent intenFile = new Intent(MainActivity.this, FileActivity.class);
//                 startActivity(intenFile);
                 break;
             case R.id.cnc_btn_json:
                 Intent intenJson = new Intent(MainActivity.this, JsonActivity.class);
                 startActivity(intenJson);
                 break;
             case R.id.cnc_btn_sqlite:
                 Intent intentSqlite = new Intent(MainActivity.this, SqliteActivity.class);
                 startActivity(intentSqlite);
                 break;
             case R.id.cnc_btn_content_provider:
                 Intent intentContentProvider = new Intent(MainActivity.this, ContentProviderActivity.class);
                 startActivity(intentContentProvider);
                 break;
             case R.id.cnc_btn_service:
                 Intent intentService = new Intent(MainActivity.this, ServiceActivity.class);
                 startActivity(intentService);
                 break;
             case R.id.cnc_btn_reflection:
                 Intent intentReflection = new Intent(MainActivity.this, ReflectionActivity.class);
                 startActivity(intentReflection);
                 break;
             case R.id.cnc_btn_fragment:
                 Intent intentFragment = new Intent(MainActivity.this, MyFragmentActivity.class);
                 startActivity(intentFragment);
                 break;
             case R.id.cnc_btn_timer:
                 Intent intentTimer = new Intent(MainActivity.this, TimerActivity.class);
                 startActivity(intentTimer);
                 break;
             case R.id.cnc_btn_picture:
                 Bundle bundle = new Bundle();
                 bundle.putInt("PIC_COUNT",90);
                 Intent intentPicture = new Intent();
                 intentPicture.setClass(MainActivity.this,PictureActivity.class);
                 intentPicture.putExtras(bundle);
                 startActivity(intentPicture);
                 break;
             case R.id.cnc_btn_dialog:
                 Intent intentDialog = new Intent(MainActivity.this, DialogActivity.class);
                 startActivity(intentDialog);
                 break;
             case R.id.cnc_btn_check_id:
                 Intent intentCheckId = new Intent(MainActivity.this,CheckIdActivity.class);
                 startActivity(intentCheckId);
                 break;
             case R.id.cnc_btn_scoller_city:
                 Intent intentScollerCity = new Intent(MainActivity.this,ScollerCityActivity.class);
                 startActivity(intentScollerCity);
                 break;
             case R.id.cnc_btn_slidingmenu:
                 Intent intentSlidingMenu = new Intent(MainActivity.this, SlidingActivity.class);
                 startActivity(intentSlidingMenu);
                 break;
             case R.id.cnc_btn_check_number_local:
                 Intent intentCheckNum = new Intent(MainActivity.this,CheckNumActivity.class);
                 startActivity(intentCheckNum);
                 break;
             case R.id.cnc_btn_self_view:
                 Intent intentSelfView = new Intent(MainActivity.this,SelfViewActivity.class);
                 startActivity(intentSelfView);
                 break;
             case R.id.cnc_btn_surfaceview:
                 Intent intentSurfaceView = new Intent(MainActivity.this, SurfaceViewActivity.class);
                 startActivity(intentSurfaceView);
                 break;
             case R.id.cnc_btn_surfaceview_new:
                 Intent intentSurfaceViewNew = new Intent(MainActivity.this,MyPlayerActivity.class);
                 startActivity(intentSurfaceViewNew);
                 break;
             case R.id.cnc_btn_handler:
                 Intent intentHandler = new Intent(MainActivity.this, HandlerActivity.class);
                 startActivity(intentHandler);
                 break;
             case R.id.cnc_btn_popupwindow:
                 Intent intentPopupWindow = new Intent(MainActivity.this, PopupWindowActivity.class);
                 startActivity(intentPopupWindow);
                 break;
             case R.id.cnc_btn_event_bus:
                 Intent intentEventBus = new Intent(MainActivity.this, EventBusActivity.class);
                 startActivity(intentEventBus);
                 break;
             case R.id.cnc_btn_layout:
                 Intent intentLayout = new Intent(MainActivity.this, LayoutActivity.class);
                 startActivity(intentLayout);
                 break;
             case R.id.cnc_btn_other_apk:
                 Intent intentOtherApk = new Intent(MainActivity.this, OtherApkActivity.class);
                 startActivity(intentOtherApk);
                 break;
             case R.id.cnc_btn_md5:
                 Intent intentMd5 = new Intent(MainActivity.this, Md5Activity.class);
                 startActivity(intentMd5);
                 break;
             case R.id.cnc_btn_jsonxml:
                 Intent intentJsonXml = new Intent(MainActivity.this, JsonXmlActivity.class);
                 startActivity(intentJsonXml);
                 break;
             case R.id.cnc_btn_sort:
                 Intent intentSort = new Intent(MainActivity.this, SortActivity.class);
                 startActivity(intentSort);
                break;
             case R.id.cnc_btn_keypad:
                 Intent intentKeyPad = new Intent(MainActivity.this, KeyPadActivity.class);
                 startActivity(intentKeyPad);
                 break;
             case R.id.cnc_btn_toast:
                 Intent intentToast = new Intent(MainActivity.this,ToastActivity.class);
                 startActivity(intentToast);
                 break;
         }
    }

    private void findView(){
        mButtonShareprefence  = (Button) this.findViewById(R.id.cnc_btn_shareprefence);
        mButtonFile = (Button) this.findViewById(R.id.cnc_btn_file);
        mButtonJson = (Button) this.findViewById(R.id.cnc_btn_json);
        mButtonSqlite = (Button) this.findViewById(R.id.cnc_btn_sqlite);
        mButtonContentrovider = (Button) this.findViewById(R.id.cnc_btn_content_provider);
        mButtonService = (Button) this.findViewById(R.id.cnc_btn_service);
        mButtonReflection = (Button) this.findViewById(R.id.cnc_btn_reflection);
        mButtonFragment = (Button) this.findViewById(R.id.cnc_btn_fragment);
        mButtonTimer = (Button) this.findViewById(R.id.cnc_btn_timer);
        mButtonPicture = (Button) this.findViewById(R.id.cnc_btn_picture);
        mButtonDialog = (Button) this.findViewById(R.id.cnc_btn_dialog);
        mButtonCheckId = (Button) this.findViewById(R.id.cnc_btn_check_id);
        mButtonScollerCity = (Button) this.findViewById(R.id.cnc_btn_scoller_city);
        mButtonSlidingMenu = (Button) this.findViewById(R.id.cnc_btn_slidingmenu);
        mButtonCheckNumber = (Button) this.findViewById(R.id.cnc_btn_check_number_local);
        mButtonSelfView = (Button) this.findViewById(R.id.cnc_btn_self_view);
        mButtonSurfaceView = (Button) this.findViewById(R.id.cnc_btn_surfaceview);
        mButtonSurface_new = (Button) this.findViewById(R.id.cnc_btn_surfaceview_new);
        mButtonHandler  = (Button) this.findViewById(R.id.cnc_btn_handler);
        mButtonPopupWindow = (Button) this.findViewById(R.id.cnc_btn_popupwindow);
        mButtonEventBus = (Button) this.findViewById(R.id.cnc_btn_event_bus);
        mButtonLayout = (Button) this.findViewById(R.id.cnc_btn_layout);
        mButtonOtherApk = (Button)this.findViewById(R.id.cnc_btn_other_apk);
        mButtonMd5 = (Button) this.findViewById(R.id.cnc_btn_md5);
        mButtonJsonXml = (Button) this.findViewById(R.id.cnc_btn_jsonxml);
        mButtonSort = (Button) this.findViewById(R.id.cnc_btn_sort);
        mButtonKeyPad = (Button) this.findViewById(R.id.cnc_btn_keypad);
        mButtonToast = (Button) this.findViewById(R.id.cnc_btn_toast);
    }

    private void initView(){
        mButtonShareprefence.setOnClickListener(this);
        mButtonFile.setOnClickListener(this);
        mButtonJson.setOnClickListener(this);
        mButtonSqlite.setOnClickListener(this);
        mButtonContentrovider.setOnClickListener(this);
        mButtonService.setOnClickListener(this);
        mButtonReflection.setOnClickListener(this);
        mButtonFragment.setOnClickListener(this);
        mButtonTimer.setOnClickListener(this);
        mButtonPicture.setOnClickListener(this);
        mButtonDialog.setOnClickListener(this);
        mButtonCheckId.setOnClickListener(this);
        mButtonScollerCity.setOnClickListener(this);
        mButtonSlidingMenu.setOnClickListener(this);
        mButtonCheckNumber.setOnClickListener(this);
        mButtonSelfView.setOnClickListener(this);
        mButtonSurfaceView.setOnClickListener(this);
        mButtonSurface_new.setOnClickListener(this);
        mButtonHandler.setOnClickListener(this);
        mButtonPopupWindow.setOnClickListener(this);
        mButtonEventBus.setOnClickListener(this);
        mButtonLayout.setOnClickListener(this);
        mButtonOtherApk.setOnClickListener(this);
        mButtonMd5.setOnClickListener(this);
        mButtonJsonXml.setOnClickListener(this);
        mButtonSort.setOnClickListener(this);
        mButtonKeyPad.setOnClickListener(this);
        mButtonToast.setOnClickListener(this);
    }
}
