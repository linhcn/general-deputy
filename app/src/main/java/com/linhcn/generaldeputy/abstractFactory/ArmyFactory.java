package com.linhcn.generaldeputy.abstractFactory;

/**
 * Created by linhcn on 9/28/16.
 */
public class ArmyFactory {
    public static Army getArmy(ArmyAbstractFactory armyAbstractFactory){
        return armyAbstractFactory.createArmy();
    }
}
