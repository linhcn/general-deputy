package com.linhcn.generaldeputy.analystAlgorithms;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.linhcn.generaldeputy.MethodPlayActivity;
import com.linhcn.generaldeputy.abstractFactory.Property;
import com.linhcn.generaldeputy.data.CONST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by linhcn on 10/12/16.
 */
public class AnalystPlayerGo {
    private String TAG = "AnalystPCGo";

    private Context context;

    public AnalystPlayerGo(Context context) {
        this.context = context;
    }

    private List<Property> properties = new ArrayList<>();
    private List<Property> propertiesKills = new ArrayList<>();
    public  Integer[] thumbIdsChangeTemp;
    public Property propertyMax;
    private int valueMax = 0;// max = 1;

    /* review all case turn it can go, and then use random to choose an case to go*/
    public void findTurn() {
        if (CONST.colorCPUChoose.equals(CONST.light)) {
            for (int i = 0; i < CONST.thumbIds.length; i++) {
                if (CONST.thumbIds[i] == CONST.deputyIdImageDark || CONST.thumbIds[i] == CONST.generalIdImageDark || CONST.thumbIds[i] == CONST.soliderIdImageDark) {
                    conditionFilter(i);
                }
            }
        } else {
            for (int i = 0; i < CONST.thumbIds.length; i++) {
                if (CONST.thumbIds[i] == CONST.deputyIdImageLight || CONST.thumbIds[i] == CONST.generalIdImageLight || CONST.thumbIds[i] == CONST.soliderIdImageLight) {
                    conditionFilter(i);
                }
            }
        }
    }

    public void conditionFilter(int i) {
        for (int j = 0; j < CONST.thumbIds.length; j++) {
            if (CONST.thumbIds[j] == CONST.emptyIdImage) {
                if (MethodPlayActivity.armies.get(0).go(i, j, CONST.thumbIds[i], CONST.thumbIds[j])) {
                    Property property = new Property(i, j, CONST.thumbIds[i], CONST.thumbIds[j]);
                    properties.add(property);
                    CONST.thumbIds = thumbIdsChangeTemp;
                }
            } else {
                if (MethodPlayActivity.armies.get(0).kill(i, j, CONST.thumbIds[i], CONST.thumbIds[j])) {
                    Property property = new Property(i, j, CONST.thumbIds[i], CONST.thumbIds[j]);
                    propertiesKills.add(property);
                    CONST.thumbIds = thumbIdsChangeTemp;
                }
            }
        }
    }

    public void findTurnNext(){
        for (Property property: properties) {

        }
    }
    public void analystTurn(){
        thumbIdsChangeTemp = CONST.thumbIds.clone();
        findTurn();
        if (propertiesKills.size()>0){
            Random random = new Random();
            propertyMax = propertiesKills.get(random.nextInt(properties.size()));
        }
        for (int i = 0; i < properties.size(); i++){

        }

    }


}
