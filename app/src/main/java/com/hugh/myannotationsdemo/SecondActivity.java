package com.hugh.myannotationsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.ViewById;

/**
 * Created by hugh on 2016/3/10.
 */
@EActivity(R.layout.activity_second)
public class SecondActivity extends Activity {

    /*
    * 获取上一个活动传过来的值
    * */
    @Extra(FirstActivity.NAME_KEY)
    String name;

    @Extra(FirstActivity.AGE_KEY)
    String age;

    @ViewById(R.id.tv_name)
    TextView tv_name;
    @ViewById(R.id.tv_age)
    TextView tv_age;

    @AfterViews
    public void initViews(){
        tv_name.setText(name);
        tv_age.setText(age);
    }

    /*
    * 长按事件
    * */
    @LongClick({R.id.tv_name,R.id.tv_age})
    public void showToast() {
        Toast.makeText(this, "Succeed", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
