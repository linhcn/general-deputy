package com.linhcn.generaldeputy.abstractFactory;

/**
 * Created by linhcn on 10/4/16.
 */
public class Property {
    private int positionGo;
    private int positionDestination;
    private int itemGo;
    private int itemDestination;

    public Property(){}

    public Property(int positionGo,int positionDestination,int itemGo,int itemDestination){
        this.positionGo = positionGo;
        this.positionDestination = positionDestination;
        this.itemGo = itemGo;
        this.itemDestination = itemDestination;
    }

    public int getItemDestination() {
        return itemDestination;
    }

    public int getItemGo() {
        return itemGo;
    }

    public int getPositionDestination() {
        return positionDestination;
    }

    public int getPositionGo() {
        return positionGo;
    }

    public void setItemDestination(int itemDestination) {
        this.itemDestination = itemDestination;
    }

    public void setItemGo(int itemGo) {
        this.itemGo = itemGo;
    }

    public void setPositionDestination(int positionDestination) {
        this.positionDestination = positionDestination;
    }

    public void setPosititionGo(int positionGo) {
        this.positionGo = positionGo;
    }

    @Override
    public String toString() {
        return "positionGo: "+positionGo+"; positionDestination: "+positionDestination+"; itemGo: "+itemGo+"; itemDestination: "+itemDestination;
    }
}
