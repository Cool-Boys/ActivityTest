package com.example.yxl.activitytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by yxl on 2016-06-27.
 */
public class FirstActivity extends BaseActivity {


    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, FirstActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Intent intent=getIntent();
        String data=intent.getStringExtra("param1");
        String strEmail=intent.getStringExtra("param2");
        Toast.makeText(FirstActivity.this,data+" 欢迎"+strEmail,Toast.LENGTH_LONG).show();




        Button btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                String strEmail=intent.getStringExtra("extra_email");
                Intent reIntent = new Intent(FirstActivity.this,
                        LoginActivity.class);
                reIntent.putExtra("data_return", strEmail);
//                setResult(RESULT_OK, intent);
//                finish();

                startActivity(reIntent);
            }
        });


    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }
    @Override
    public void onBackPressed() {
//        Intent intent = new Intent();
//        intent.putExtra("data_return", "Hello FirstActivity");
//        setResult(RESULT_OK, intent);
//        finish();
        ActivityCollector.finishAll();
    }
}
