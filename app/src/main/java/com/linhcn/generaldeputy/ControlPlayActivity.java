package com.linhcn.generaldeputy;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

//import com.linhcn.generaldeputy.data.Army;
import com.linhcn.generaldeputy.analystAlgorithms.AnalystPCGo;
import com.linhcn.generaldeputy.data.CONST;
import com.linhcn.generaldeputy.adapter.GridViewAdapter;

/**
 * This is Activity use to control play between Machine and Player
 * Created by linhcn on 9/19/16.
 */
public class ControlPlayActivity extends Activity {

    private final String TAG = "ControlPlayActivity";

    /*width and height of device*/
    private int width, height;
    private int flagGo;
    private GridView gvTableFlat;
    private GridViewAdapter gridViewAdapter;
    private RelativeLayout rlTableFlat;
    private ImageButton imgbtnResume,imgbtnForword;
    private AnalystPCGo analystPCGo;

    private int itemGo = -1;
    private int itemDestination = -1;
    private int positionDestination = -1;
    private int positionGo = -1;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_play);

        analystPCGo = new AnalystPCGo(this);

        rlTableFlat = (RelativeLayout) findViewById(R.id.rl_table_flat);
        gvTableFlat = (GridView) findViewById(R.id.gv_table_flat);
        imgbtnResume = (ImageButton) findViewById(R.id.btn_resume_playing);
        imgbtnForword = (ImageButton) findViewById(R.id.img_btn_forward);
        // remove selector when click item
        gvTableFlat.setSelector(new ColorDrawable(Color.TRANSPARENT));
        // get width and height of device
        Display display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
        // setup status of component when start
        imgbtnResume.setEnabled(false);
        controlView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        gridViewAdapter = new GridViewAdapter(this, CONST.thumbIds, width, height);
        gvTableFlat.setAdapter(gridViewAdapter);
        managerClick();
    }

    public void managerClick() {
        gvTableFlat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.d(TAG, "onItemClick: int: " + i);
                // default type normal is can clickable else if type 1 is can't clickable
                if (flagGo == 1) {
                    if (CONST.thumbIds[i] == CONST.emptyIdImage || CONST.thumbIds[i] != MethodPlayActivity.getPlayer().getGeneral() || CONST.thumbIds[i] != MethodPlayActivity.getPlayer().getDeputy() || CONST.thumbIds[i] != MethodPlayActivity.getPlayer().getSolider()) {
                        itemDestination = CONST.thumbIds[i];
                        positionDestination = i;
                        gvTableFlat.setEnabled(false);
                        CONST.historyStack.add(CONST.thumbIds.clone());
                        CONST.checkAnalyst = 0;
                        if (MethodPlayActivity.getPlayer().go(positionGo, positionDestination, itemGo, itemDestination) || MethodPlayActivity.getPlayer().kill(positionGo, positionDestination, itemGo,itemDestination)) {
                            Log.d(TAG, "onItemClick: positionGo: " + positionGo + " positionDestination: " + positionDestination + "; itemDestination: " + itemDestination + "; itemGo: " + itemGo);
                            gridViewAdapter.notifyDataSetChanged();
                            imgbtnResume.setEnabled(false);
                            computerGo();
                        } else {
                            gvTableFlat.setEnabled(true);
                        }
                        resetVariable();

                    } else {
                        itemGo = CONST.thumbIds[i];
                        positionGo = i;
                        flagGo = 1;
                    }
                } else if (CONST.thumbIds[i] != CONST.emptyIdImage) {
                    itemGo = CONST.thumbIds[i];
                    positionGo = i;
                    flagGo = 1;
                }
            }
        });

        imgbtnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!CONST.historyStack.isEmpty()){
                    if (CONST.historyStack.size() > 1){
                        CONST.thumbIds = CONST.historyStack.pop();
                    }else{
                        CONST.thumbIds = CONST.historyStack.peek();
                    }
                    gridViewAdapter = new GridViewAdapter(getApplicationContext(), CONST.thumbIds, width, height);
                    gvTableFlat.setAdapter(gridViewAdapter);
                    gvTableFlat.setEnabled(true);
                }else{
                    Log.d(TAG, "onClick: History Stack is empty ");
                }
            }
        });

        imgbtnForword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    public void computerGo() {
        // computer go
        countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                analystPCGo.randomTurn();
                gridViewAdapter.notifyDataSetChanged();
                gvTableFlat.setEnabled(true);
                imgbtnResume.setEnabled(true);
                Log.d(TAG, "onFinish: this size historyStack After push: "+CONST.historyStack.size());
            }
        };
        countDownTimer.start();
    }

    public void resetVariable() {
        itemGo = -1;
        itemDestination = -1;
        positionDestination = -1;
        positionGo = -1;
        flagGo = 0;
    }

    public void controlView() {

        RelativeLayout.LayoutParams rlParamTableFlat = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rlParamTableFlat.width = (width * 440) / 480;
        rlParamTableFlat.height = (height * 440) / 800;
        rlParamTableFlat.addRule(RelativeLayout.CENTER_IN_PARENT);
        rlTableFlat.setLayoutParams(rlParamTableFlat);

        RelativeLayout.LayoutParams rlParamGirdView = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rlParamGirdView.width = (width * 440) / 480;
        rlParamGirdView.height = (height * 440) / 800;
        rlParamGirdView.addRule(RelativeLayout.CENTER_IN_PARENT);
        gvTableFlat.setLayoutParams(rlParamGirdView);
        gvTableFlat.setNumColumns(5);
        gvTableFlat.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        gvTableFlat.setClipChildren(true);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

        }
        return super.onKeyDown(keyCode, event);
    }
}
