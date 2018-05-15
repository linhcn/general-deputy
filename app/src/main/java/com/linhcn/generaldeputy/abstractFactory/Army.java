package com.linhcn.generaldeputy.abstractFactory;

import android.util.Log;

import com.linhcn.generaldeputy.data.CONST;

/**
 * Created by linhcn on 9/28/16.
 */
public abstract class Army implements HeadQuarter {

    private String TAG = "Army";
    private int itemGo = -1;
    private int itemDestination = -1;
    private int positionDestination = -1;
    private int positionGo = -1;
    private int[] prisoner = new int[3];

    public abstract int getGeneral();

    public abstract int getDeputy();

    public abstract int getSolider();

    public abstract String getName();

    public abstract String getColor();

    public abstract void setGeneral(int general);

    public abstract void setDeputy(int deputy);

    public abstract void setSolider(int solider);

    public abstract void setName(String name);

    public abstract void setColor(String color);

    @Override
    public int getPrisoner(int typePrisoner) {
        if (typePrisoner < 2 && typePrisoner >= 0) {
            return prisoner[typePrisoner];
        } else {
            Log.e(TAG, "getPrisoner: value not accept");
            return 0;
        }
    }

    @Override
    public void setPrisoner(int prisoner) {
        this.prisoner[prisoner] = getPrisoner(prisoner) + 1;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "; General: " + getGeneral() + "; Deputy: " + getDeputy() + "; Solider: " + getSolider();
    }

    // pc go or player go
    @Override
    public boolean go(int positionGo, int positionDestination, int itemGo, int itemDestination) {
        this.positionDestination = positionDestination;
        this.positionGo = positionGo;
        this.itemDestination = itemDestination;
        this.itemGo = itemGo;
        // if you choose color dark => only move army have color is dark

        if (getName().equals(CONST.namePeople)) {
            if (getColor().equals(CONST.dark)) {
                if (itemGo == CONST.deputyIdImageDark || itemGo == CONST.generalIdImageDark || itemGo == CONST.soliderIdImageDark) {
                    return intoGo();
                }
            } else {
                if (itemGo == CONST.deputyIdImageLight || itemGo == CONST.generalIdImageLight || itemGo == CONST.soliderIdImageLight) {
                    return intoGo();
                }
            }
        } else {
            if (getColor().equals(CONST.light)) {
                if (itemGo == CONST.deputyIdImageLight || itemGo == CONST.generalIdImageLight || itemGo == CONST.soliderIdImageLight) {
                    return intoGo();
                }
            } else {
                if (itemGo == CONST.deputyIdImageDark || itemGo == CONST.generalIdImageDark || itemGo == CONST.soliderIdImageDark) {
                    return intoGo();
                }
            }
        }
        return false;
    }

    // handle total condition to go,It will be call by function go()
    private boolean intoGo() {
        // not go to position 12 if don't kill solider
        if (positionDestination == 12) {
            if (getPrisoner(0) <= 0) {
                return false;
            }
        }
        if (itemDestination == CONST.emptyIdImage) {
            if (lineHorizontal() || lineVertical() || lineDiagonal1() || lineDiagonal2()) {
                if (getName().equals(CONST.namePeople) && CONST.checkAnalyst == 0) {
                    update();
                    CONST.checkAnalyst = 1;
                }
                return true;
            }
        } else {
            System.out.println("can't not go, itemDestination isn't empty");
        }
        return false;
    }

    private final boolean intoKill() {
        if (!getName().equals(CONST.nameMachine) && CONST.checkAnalyst == 0) {
            Log.d(TAG, "intoKill: update ");
            update();
            CONST.checkAnalyst = 1;
        }
        return true;
    }

    // update position on view when run function intoGo()
    public final void update() {
        // clone to save history after change data;
        // change data;
        CONST.thumbIds[positionGo] = CONST.emptyIdImage;
        CONST.thumbIds[positionDestination] = itemGo;
        CONST.isFinishTurn = true;
        resetHistoryGo();
    }

    private final void resetHistoryGo() {
        itemGo = -1;
        itemDestination = -1;
        positionDestination = -1;
        positionGo = -1;
    }

    // set condition to go on line horizontal, It will be call by function intoGo()
    private final boolean lineHorizontal() {
        switch (positionDestination) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                switch (positionGo) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return conditionOnLine(1);
                }
                break;
            case 9:
            case 8:
            case 7:
            case 6:
            case 5:
                switch (positionGo) {
                    case 9:
                    case 8:
                    case 7:
                    case 6:
                    case 5:
                        return conditionOnLine(1);
                }
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                switch (positionGo) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        return conditionOnLine(1);
                }
                break;
            case 19:
            case 18:
            case 17:
            case 16:
            case 15:
                switch (positionGo) {
                    case 19:
                    case 18:
                    case 17:
                    case 16:
                    case 15:
                        return conditionOnLine(1);
                }
                break;
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                switch (positionGo) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        return conditionOnLine(1);
                }
                break;
        }
        return false;
    }

    // set condition to go on line vertical
    private final boolean lineVertical() {
        switch (positionDestination) {
            case 0:
            case 5:
            case 10:
            case 15:
            case 20:
                switch (positionGo) {
                    case 0:
                    case 5:
                    case 10:
                    case 15:
                    case 20:
                        return conditionOnLine(5);
                }
                break;
            case 1:
            case 6:
            case 11:
            case 16:
            case 21:
                switch (positionGo) {
                    case 1:
                    case 6:
                    case 11:
                    case 16:
                    case 21:
                        return conditionOnLine(5);
                }
                break;
            case 2:
            case 7:
            case 12:
            case 17:
            case 22:
                switch (positionGo) {
                    case 2:
                    case 7:
                    case 12:
                    case 17:
                    case 22:
                        return conditionOnLine(5);
                }
                break;
            case 3:
            case 8:
            case 13:
            case 18:
            case 23:
                switch (positionGo) {
                    case 3:
                    case 8:
                    case 13:
                    case 18:
                    case 23:
                        return conditionOnLine(5);
                }
                break;
            case 4:
            case 9:
            case 14:
            case 19:
            case 24:
                switch (positionGo) {
                    case 4:
                    case 6:
                    case 14:
                    case 19:
                    case 24:
                        return conditionOnLine(5);
                }
                break;
        }
        return false;
    }

    // set condition to go on line diagonal
    private final boolean lineDiagonal1() {
        switch (positionDestination) {
            // line 1
            case 2:
                switch (positionGo) {
                    case 6:
                        return true;
                }
                break;
            case 6:
                switch (positionGo) {
                    case 2:
                        return true;
                    case 10:
                        return true;
                }
                break;
            case 10:
                switch (positionGo) {
                    case 6:
                        return true;
                }
                break;
            //line 2
            case 20:
                switch (positionGo) {
                    case 16:
                        return true;

                }
                break;
            case 16:
                switch (positionGo) {
                    case 20:
                        return true;
                    case 12:
                        return true;
                }
                break;
            case 12:
                switch (positionGo) {
                    case 8:
                        return true;
                    case 16:
                        return true;
                }
                break;
            case 8:
                switch (positionGo) {
                    case 4:
                        return true;
                    case 12:
                        return true;
                }
                break;
            case 4:
                switch (positionGo) {
                    case 8:
                        return true;
                }
                break;
            //line 3
            case 14:
                switch (positionGo) {
                    case 18:
                        return true;
                }
                break;
            case 18:
                switch (positionGo) {
                    case 14:
                        return true;
                    case 22:
                        return true;
                }
                break;
            case 22:
                switch (positionGo) {
                    case 18:
                        return true;
                }
                break;

        }
        return false;
    }

    // set condition to go on line diagonal
    private final boolean lineDiagonal2() {
        switch (positionDestination) {
            // line 1
            case 2:
                switch (positionGo) {
                    case 8:
                        return true;
                }
                break;
            case 8:
                switch (positionGo) {
                    case 2:
                        return true;
                    case 14:
                        return true;
                }
                break;
            case 14:
                switch (positionGo) {
                    case 8:
                        return true;
                }
                break;
            //line 2
            case 0:
                switch (positionGo) {
                    case 6:
                        return true;

                }
                break;
            case 6:
                switch (positionGo) {
                    case 0:
                        return true;
                    case 12:
                        return true;
                }
                break;
            case 12:
                switch (positionGo) {
                    case 6:
                        return true;
                    case 18:
                        return true;
                }
                break;
            case 18:
                switch (positionGo) {
                    case 24:
                        return true;
                    case 12:
                        return true;
                }
                break;
            case 24:
                switch (positionGo) {
                    case 18:
                        return true;
                }
                break;
            //line 3
            case 10:
                switch (positionGo) {
                    case 16:
                        return true;
                }
                break;
            case 16:
                switch (positionGo) {
                    case 10:
                        return true;
                    case 22:
                        return true;
                }
                break;
            case 22:
                switch (positionGo) {
                    case 16:
                        return true;
                }
                break;
        }
        return false;
    }

    // set condition to go on  follow rule use for condition on line
    private final boolean conditionOnLine(int add) {
        if (positionDestination < positionGo && positionDestination + add == positionGo) {
            return true;
        } else if (positionDestination > positionGo && positionGo + add == positionDestination) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean kill(int positionKill, int positionTarget, int itemKill, int itemTarget) {
        this.itemGo = itemKill;
        this.itemDestination = itemTarget;
        this.positionGo = positionKill;
        this.positionDestination = positionTarget;
        System.out.println("Count prisoner: " + getPrisoner(0));
        // if you choose color dark => only move army have color is dark
        if (itemGo == getDeputy() || itemGo == getGeneral()) {
            Log.d(TAG, "kill:");
            if (getColor().equals(CONST.dark)) {
                if (itemTarget == CONST.deputyIdImageLight) {
                    // check the enemy been killed enough 2
                    System.out.println(getPrisoner(0));
                    if (getPrisoner(0) == 2) {
                        if (caseKill()) {
                            // add prisoner
                            setPrisoner(1);
                            return intoKill();
                        }
                    }
                } else if (itemTarget == CONST.soliderIdImageLight) {
                    if (caseKill()) {
                        // add prisoner
                        setPrisoner(0);
                        return intoKill();
                    }
                } else if (itemTarget == CONST.generalIdImageLight) {
                    // check the enemy been killed enough 3
                    if (getPrisoner(0) == 3) {
                        if (itemGo == CONST.generalIdImageDark) {
                            if (caseKill()) {
                                // add prisoner
                                setPrisoner(2);
                                return intoKill();
                            }
                        }
                    }
                } else {
                    Log.d(TAG, "kill: can not kill you not equal lever");
                }
            } else {
                if (itemTarget == CONST.deputyIdImageDark) {
                    // check the enemy been killed enough 2
                    if (getPrisoner(0) == 2) {
                        if (caseKill()) {
                            // add prisoner
                            setPrisoner(1);
                            return intoKill();
                        }
                    }
                } else if (itemTarget == CONST.soliderIdImageDark) {
                    if (caseKill()) {
                        // add prisoner
                        setPrisoner(0);
                        return intoKill();
                    }
                } else if (itemTarget == CONST.generalIdImageDark) {
                    // check the enemy been killed enough 3
                    if (getPrisoner(0) == 3) {
                        if (itemGo == CONST.generalIdImageDark) {
                            if (caseKill()) {
                                // add prisoner
                                setPrisoner(2);
                                return intoKill();
                            }
                        }
                    }
                } else {
                    Log.d(TAG, "kill: can not kill you not equal lever");
                }
            }
        }
        return false;
    }

    // call by kill()
    private boolean caseKill() {
        switch (positionDestination) {
            case 0:
                int temp0[] = {10, 12, 2, 5, 6, 1};
                return conditionKill(temp0);
            case 1:
                int temp1[] = {3, 11, 2, 6};
                return conditionKill(temp1);
            case 2:
                int temp2[] = {0, 4, 10, 14, 12, 1, 3, 6, 8, 7};
                return conditionKill(temp2);
            case 3:
                int temp3[] = {1, 13, 2, 8};
                return conditionKill(temp3);
            case 4:
                int temp4[] = {14, 12, 2, 9, 8, 3};
                return conditionKill(temp4);
            case 5:
                int temp5[] = {7, 15, 6, 10};
                return conditionKill(temp5);
            case 6:
                int temp6[] = {8, 18, 16, 7, 12, 11};
                return conditionKill(temp6);
            case 7:
                int temp7[] = {9, 17, 5, 8, 12, 6};
                return conditionKill(temp7);
            case 8:
                int temp8[] = {6, 16, 18, 7, 12, 13};
                return conditionKill(temp8);
            case 9:
                int temp9[] = {7, 19, 8, 14};
                return conditionKill(temp9);
            case 10:
                int temp10[] = {0, 20, 12, 2, 22, 5, 15, 11, 6, 16};
                return conditionKill(temp10);
            case 11:
                int temp11[] = {1, 21, 13, 6, 16, 12};
                return conditionKill(temp11);
            case 12:
                int temp12[] = {2, 0, 4, 14, 24, 22, 20, 10, 7, 6, 8, 13, 18, 17, 16, 11};
                return conditionKill(temp12);
            case 13:
                int temp13[] = {3, 11, 23, 8, 12, 18};
                return conditionKill(temp13);
            case 14:
                int temp14[] = {4, 2, 12, 22, 24, 9, 8, 13, 22, 19};
                return conditionKill(temp14);
            case 15:
                int temp15[] = {5, 17, 10, 16};
                return conditionKill(temp15);
            case 16:
                int temp16[] = {6, 8, 18, 11, 12, 17};
                return conditionKill(temp16);
            case 17:
                int temp17[] = {19, 7, 15, 18, 12, 16};
                return conditionKill(temp17);
            case 18:
                int temp18[] = {16, 6, 8, 17, 12, 13};
                return conditionKill(temp18);
            case 19:
                int temp19[] = {17, 9, 18, 14};
                return conditionKill(temp19);
            case 20:
                int temp20[] = {10, 12, 22, 15, 16, 21};
                return conditionKill(temp20);
            case 21:
                int temp21[] = {11, 23, 16, 22};
                return conditionKill(temp21);
            case 22:
                int temp22[] = {10, 14, 12, 20, 24, 16, 18, 17, 21, 23};
                return conditionKill(temp22);
            case 23:
                int temp23[] = {13, 21, 18, 12};
                return conditionKill(temp23);
            case 24:
                int temp24[] = {14, 12, 12, 19, 8, 23};
                return conditionKill(temp24);
        }
        return false;
    }

    // check position target is true, call caseKill()
    public boolean conditionKill(int[] array) {
        int temp = array.length / 2;
        for (int i = 0; i < array.length / 2; i++) {
            if (positionGo == array[i]) {
                if (checkKill(array[temp])) {
                    return true;
                }
            }
            temp++;
        }
        return false;
    }

    // check supporter is true call by conditionKill()
    private boolean checkKill(int supporter) {
        Log.d(TAG, "checkKill: supporter: " + CONST.thumbIds[supporter] + "; solider: " + getSolider() + "; deputy: " + getDeputy());
        if (CONST.thumbIds[supporter] == getSolider() || CONST.thumbIds[supporter] == getDeputy()) {
            return true;
        }
        return false;

    }

}
