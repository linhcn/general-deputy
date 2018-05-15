package com.linhcn.generaldeputy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnClickListener{

    private RelativeLayout rlContent;
    public static int[][] MATRIX_DATA;
    private ImageButton imgBtPlay,imgBtRank,imgBtSetting,imgBtDirect,imgBtExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init(){
        imgBtPlay = (ImageButton) findViewById(R.id.btn_play);
        imgBtRank = (ImageButton) findViewById(R.id.btn_rank);
        imgBtSetting = (ImageButton) findViewById(R.id.btn_setting);
        imgBtDirect = (ImageButton) findViewById(R.id.btn_direct);
        imgBtExit = (ImageButton) findViewById(R.id.btn_exit);

        imgBtPlay.setOnClickListener(this);
        imgBtRank.setOnClickListener(this);
        imgBtDirect.setOnClickListener(this);
        imgBtSetting.setOnClickListener(this);
        imgBtExit.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_play:
                Intent intent = new Intent(MainActivity.this,MethodPlayActivity.class);
                startActivity(intent);
                break;

        }
    }


    public void ControlView(){

    }
}
