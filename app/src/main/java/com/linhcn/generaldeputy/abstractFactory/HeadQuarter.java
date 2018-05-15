package com.linhcn.generaldeputy.abstractFactory;

/**
 * Created by linhcn on 9/28/16.
 */
public interface HeadQuarter {
    boolean go(int positionGo, int positionDestination,int itemDestination,int itemGo);
    boolean kill(int positionkill, int positionTarget,int itemTarget,int itemKill);
    int getPrisoner(int typePrisoner);
    void setPrisoner(int prisoner);
//    void saveState();
}
