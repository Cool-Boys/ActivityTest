package com.example.yxl.activitytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by yxl on 2016-07-03.
 */
public class fruitDetail extends Activity {
    ImageView fruitImage;
    TextView fruitName;
    TextView fruitTitle;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    String bName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_detail);
        Intent intent = getIntent();
        String fruit = intent.getStringExtra("data");
        fruitImage = (ImageView) findViewById(R.id.detailfruit_image);
        fruitName = (TextView) findViewById
                (R.id.detailfruit_name);
        fruitTitle = (TextView) findViewById
                (R.id.detailfruit_title);

        switch (fruit) {

            case "Apple":
                fruitImage.setImageResource(R.drawable.applem);
                String strDetail = "  苹果（Apple），是最常见的水果之一。苹果树属于蔷薇科，落叶乔木，叶椭圆形，有锯齿。其果实球形，味甜，口感爽脆，且富含丰富的营养，是世界四大水果之冠。苹果通常为红色，不过也有黄色和绿色。苹果是一种低热量食物，每100克只产生60千卡热量。苹果中营养成份可溶性大，易被人体吸收，故有“活水”之称，其有利于溶解硫元素，使皮肤润滑柔嫩[1]  。据说每天一苹果，医生远离你。";
                fruitName.setText(strDetail);
                fruitTitle.setText("苹果(" + fruit + ")");
                break;
            case "Mango":
                fruitImage.setImageResource(R.drawable.mangom);
                strDetail = "  芒果是杧果（中国植物志）的通俗名（拉丁学名：Mangifera indica L.），芒果是一种原产印度的漆树科常绿大乔木，叶革质，互生；花小，杂性，黄色或淡黄色，成顶生的圆锥花序。核果大，压扁，长5-10厘米，宽3-4.5厘米，成熟时黄色，味甜，果核坚硬。";
                fruitName.setText(strDetail);
                fruitTitle.setText("芒果(" + fruit + ")");
                break;
            default:
                fruitTitle.setText(fruit);
                break;
        }
        initMediaPlayer();
        ImageView img = (ImageView) findViewById(R.id.detailsound);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(fruitDetail.this,"声音",Toast.LENGTH_SHORT).show();
                ImageView   soudImage = (ImageView) findViewById(R.id.detailsound);
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start(); // 开始播放
                    soudImage.setImageResource(R.drawable.sound_off);
                }
                else {
                    mediaPlayer.reset(); // 停止播放
                    initMediaPlayer();
                    soudImage.setImageResource(R.drawable.sound_on);
                }
            }
        });

    }
    public void onReceive(Context context, Intent intent) {
        bName=context.getPackageName();
    }
    private void initMediaPlayer() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(),
                    "apple.mp3");
            mediaPlayer.setDataSource(file.getPath()); // 指定音频文件的路径
            mediaPlayer.prepare(); // 让MediaPlayer进入到准备状态
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
