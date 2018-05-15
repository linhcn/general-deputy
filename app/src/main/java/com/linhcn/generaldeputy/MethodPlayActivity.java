package com.linhcn.generaldeputy;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.linhcn.generaldeputy.abstractFactory.Army;
import com.linhcn.generaldeputy.abstractFactory.ArmyFactory;
import com.linhcn.generaldeputy.abstractFactory.PCFactory;
import com.linhcn.generaldeputy.abstractFactory.PlayerFactory;
import com.linhcn.generaldeputy.data.CONST;
import com.linhcn.generaldeputy.dialog.ChooseColorDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linhcn on 9/17/16.
 */
public class MethodPlayActivity extends Activity implements View.OnClickListener{

    private ImageButton imgBtPlayMachine;
    private ImageButton imgBtPlayBluetooth;
    public static List<Army> armies = new ArrayList<>();
    private Army player = ArmyFactory.getArmy(new PlayerFactory.PlayerFactoryBuilder().setName(CONST.namePeople).setPrisoner(new int[]{0,0,0}).build());
    private Army pc = ArmyFactory.getArmy(new PCFactory.PCFactoryBuilder().setName(CONST.nameMachine).setPrisoner(new int[]{0,0,0}).build());

    // index 0 = represent for machine

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method_play);
        init();
    }

    public void init(){

        imgBtPlayMachine = (ImageButton) findViewById(R.id.btn_play_machine);
        imgBtPlayBluetooth = (ImageButton) findViewById(R.id.btn_play_bluetooth);
        imgBtPlayMachine.setOnClickListener(this);
        imgBtPlayBluetooth.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        armies.add(player);
        armies.add(pc);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_play_machine:
                ChooseColorDialog chooseColorDialog = new ChooseColorDialog(this);
                chooseColorDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                chooseColorDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                chooseColorDialog.show();
                break;
            case R.id.btn_play_bluetooth:
                break;
        }
    }

    public static Army getPlayer(){
        return armies.get(0);
    }

}
