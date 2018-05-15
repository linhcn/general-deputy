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
 * Created by linhcn on 10/3/16.
 */
public class AnalystPCGo {

    private String TAG = "AnalystPCGo";

    private Context context;
    public AnalystPCGo(Context context){
        this.context = context;
    }

    private List<Property> properties = new ArrayList<>();
    private List<Property> propertiesKills = new ArrayList<>();

    /* review all case turn it can go, and then use random to choose an case to go*/
    public void randomTurn(){
        if (CONST.colorCPUChoose.equals(CONST.light)){
            for (int i = 0 ; i < CONST.thumbIds.length; i++){
                if (CONST.thumbIds[i] == CONST.deputyIdImageLight || CONST.thumbIds[i] == CONST.generalIdImageLight|| CONST.thumbIds[i] == CONST.soliderIdImageLight){
                    conditionFilter(i);
                }
            }
        }else{
            for (int i = 0 ; i < CONST.thumbIds.length; i++){
                if (CONST.thumbIds[i] == CONST.deputyIdImageDark || CONST.thumbIds[i] == CONST.generalIdImageDark|| CONST.thumbIds[i] == CONST.soliderIdImageDark){
                    conditionFilter(i);
                }
            }
        }

        Random random = new Random();
        if (propertiesKills.size()>0){
            int caseGo = random.nextInt(propertiesKills.size());
            Log.d(TAG, "randomTurn: this is case choose from random to kill: " + propertiesKills.get(caseGo));
            MethodPlayActivity.armies.get(1).kill(propertiesKills.get(caseGo).getPositionGo(),
                    propertiesKills.get(caseGo).getPositionDestination(),
                    propertiesKills.get(caseGo).getItemGo(),
                    propertiesKills.get(caseGo).getItemDestination());
            MethodPlayActivity.armies.get(1).update();
        }else if (properties.size() > 0) {
            int caseGo = random.nextInt(properties.size());
            Log.d(TAG, "randomTurn: this is case choose from random to go: " + properties.get(caseGo));
            MethodPlayActivity.armies.get(1).go(properties.get(caseGo).getPositionGo(),
                    properties.get(caseGo).getPositionDestination(),
                    properties.get(caseGo).getItemGo(),
                    properties.get(caseGo).getItemDestination());
            MethodPlayActivity.armies.get(1).update();
        }else{
            Toast.makeText(context,"Game over!!!",Toast.LENGTH_LONG).show();
        }
        propertiesKills.clear();
        properties.clear();
        System.gc();
    }

    public void conditionFilter(int i){
        for (int j = 0 ; j <CONST.thumbIds.length;j++){
            if (CONST.thumbIds[j] == CONST.emptyIdImage) {
                if (MethodPlayActivity.armies.get(1).go(i, j,CONST.thumbIds[i], CONST.thumbIds[j])) {
                    Property property = new Property(i, j,CONST.thumbIds[i], CONST.thumbIds[j]);
                    properties.add(property);
                }
            }else{
                if (MethodPlayActivity.armies.get(1).kill(i, j,CONST.thumbIds[i], CONST.thumbIds[j])) {
                    Property property = new Property(i, j,CONST.thumbIds[i], CONST.thumbIds[j]);
                    propertiesKills.add(property);
                }
            }
        }
    }

}
