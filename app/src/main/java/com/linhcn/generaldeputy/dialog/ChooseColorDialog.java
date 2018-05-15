package com.linhcn.generaldeputy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.linhcn.generaldeputy.ControlPlayActivity;
import com.linhcn.generaldeputy.MethodPlayActivity;
import com.linhcn.generaldeputy.R;
import com.linhcn.generaldeputy.data.CONST;

/**
 * Created by linhcn on 9/26/16.
 */
public class ChooseColorDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private Button btGray, btLight;
    private Intent intent;
    private int temp;
    private int countMaxData = CONST.thumbIds.length-1;

    public ChooseColorDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_choose_color);

        btGray = (Button) findViewById(R.id.bt_gray);
        btLight = (Button) findViewById(R.id.bt_light);

        btGray.setOnClickListener(this);
        btLight.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setCanceledOnTouchOutside(false);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_gray:
                if (CONST.thumbIds[0] == CONST.soliderIdImageDark){
                    for (int i = 0; i < 12; i++) {
                        temp = CONST.thumbIds[i];
                        CONST.thumbIds[i] = CONST.thumbIds[countMaxData];
                        CONST.thumbIds[countMaxData] = temp;
                        countMaxData--;
                    }
                }
                MethodPlayActivity.getPlayer().setColor(CONST.dark);
                MethodPlayActivity.getPlayer().setGeneral(CONST.generalIdImageDark);
                MethodPlayActivity.getPlayer().setDeputy(CONST.deputyIdImageDark);
                MethodPlayActivity.getPlayer().setSolider(CONST.soliderIdImageDark);
                MethodPlayActivity.armies.get(1).setColor(CONST.light);
                MethodPlayActivity.armies.get(1).setGeneral(CONST.generalIdImageLight);
                MethodPlayActivity.armies.get(1).setDeputy(CONST.deputyIdImageLight);
                MethodPlayActivity.armies.get(1).setSolider(CONST.soliderIdImageLight);

                intent = new Intent(context, ControlPlayActivity.class);
                context.startActivity(intent);
                Log.d("asda", "onClick: "+MethodPlayActivity.armies.get(0));
                dismiss();
                break;
            case R.id.bt_light:
                // reversed array data
                if (CONST.thumbIds[0] == CONST.soliderIdImageLight){
                    for (int i = 0; i < 12; i++) {
                        temp = CONST.thumbIds[i];
                        CONST.thumbIds[i] = CONST.thumbIds[countMaxData];
                        CONST.thumbIds[countMaxData] = temp;
                        countMaxData--;
                    }
                }
                MethodPlayActivity.getPlayer().setColor(CONST.light);
                MethodPlayActivity.getPlayer().setGeneral(CONST.generalIdImageLight);
                MethodPlayActivity.getPlayer().setGeneral(CONST.deputyIdImageLight);
                MethodPlayActivity.getPlayer().setGeneral(CONST.soliderIdImageLight);
                MethodPlayActivity.armies.get(1).setColor(CONST.dark);
                MethodPlayActivity.armies.get(1).setGeneral(CONST.generalIdImageDark);
                MethodPlayActivity.armies.get(1).setGeneral(CONST.deputyIdImageDark);
                MethodPlayActivity.armies.get(1).setGeneral(CONST.soliderIdImageDark);
                CONST.colorCPUChoose = "dark";
                intent = new Intent(context, ControlPlayActivity.class);
                context.startActivity(intent);
                Log.d("asda", "onClick: "+MethodPlayActivity.armies.get(0));
                dismiss();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

        }
        return false;
    }
}
