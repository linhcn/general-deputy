package com.linhcn.generaldeputy.abstractFactory;

import com.linhcn.generaldeputy.data.CONST;

/**
 * Created by linhcn on 9/28/16.
 */
public class Test {
    public static void main(String[] arg){
        Army pc = ArmyFactory.getArmy(new PCFactory.PCFactoryBuilder().setGeneral(CONST.generalIdImageLight).setName("PC").build());
        System.out.println(pc);
        pc.setSolider(CONST.soliderIdImageLight);
        System.out.println(pc);

    }
}
