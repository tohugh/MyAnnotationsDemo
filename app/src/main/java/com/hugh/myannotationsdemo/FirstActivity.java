package com.hugh.myannotationsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionRes;
import org.androidannotations.annotations.res.StringRes;


/**
 * Created by hugh on 2016/3/10.
 */
@EActivity(R.layout.activity_main)
public class FirstActivity extends Activity {

    public static final String NAME_KEY = "name";
    public static final String AGE_KEY = "age";

    /*
    * 相当于findViewById
    * */
    @ViewById(R.id.button1)
    Button button;

    @ViewById
    TextView textview1;



    @StringRes(R.string.my_name)
    String name;

    @DimensionRes(R.dimen.font_size)
    float font_size;


    @AfterViews
    public void setTextView(){
        textview1.setText(name);
    }

    /*
    * 运行在子线程
    * */
    @Background
    public void doSth(){
        Log.i("hugh", "thread id=" + Thread.currentThread().getId());
        updateUI();
    }

    /*
    * 运行在主线程
    * */
    @UiThread
    public void updateUI() {
        textview1.setText("updateUI");
        textview1.setTextSize(font_size);
    }


    /*
    * 给按钮添加单击事件
    * */
    @Click(R.id.button1)
    public void startAty(){
        /*Intent intent = new Intent(FirstActivity.this,SecondActivity_.class);
        //Intent intent = new Intent(FirstActivity.this,MyService_.class);
        intent.putExtra(NAME_KEY,"hugh");
        intent.putExtra(AGE_KEY, "18");
        //startService(intent);
        startActivity(intent);*/

        doSth();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("hugh", "thread id=" + Thread.currentThread().getId());

    }
}
