package com.linhcn.generaldeputy.data;

import com.linhcn.generaldeputy.R;

import java.util.Stack;

/**
 * Created by linhcn on 9/12/16.
 */
public class CONST {
    // ta

    public static int checkAnalyst = 1;
    public static boolean isFinishTurn = false;
    public static String colorCPUChoose = "light";
    public static final String nameMachine= "CPU";
    public static final String namePeople = "Player";
    public static final int general = 3;
    public static final int deputy = 2;
    public static final int soldier = 1;
    public static final int empty = 0;
    public static final String dark = "dark";// Symbolic for machine
    public static final String light = "light";// Symbolic for players
    public static final String sideGo = dark;// default machine go to ahead
    public static final int soliderIdImageLight = R.drawable.icon_quan;// value = 2130837619
    public static final int generalIdImageLight = R.drawable.icon_tuong;// value = 2130837632
    public static final int deputyIdImageLight = R.drawable.icon_pho;//    value = 2130837606

    public static final int soliderIdImageDark = R.drawable.icon_quan2; // value = 2130837620
    public static final int generalIdImageDark = R.drawable.icon_tuong2;// value = 2130837633
    public static final int deputyIdImageDark = R.drawable.icon_pho2;//     value = 2130837607

    public static final int emptyIdImage = R.drawable.empty; // value = 2130837593
    /*Use to determined position of the solider */
    public static int[] piece = {
            1, 1, 3, 1, 1,
            1, 1, 0, 1, 1,
            2, 0, 0, 0, 2,
            1, 1, 0, 1, 1,
            1, 1, 3, 1, 1
    };
    /* Use to distinguish between machine an players*/
    public static int[] color = {
            1, 1, 1, 1, 1,
            1, 1, 0, 1, 1,
            1, 0, 0, 0, 2,
            2, 2, 0, 2, 2,
            2, 2, 3, 2, 2
    };
    /*data image*/
    public static Integer[] thumbIds = {
            soliderIdImageLight, soliderIdImageLight, generalIdImageLight, soliderIdImageLight, soliderIdImageLight,
            soliderIdImageLight, soliderIdImageLight, emptyIdImage, soliderIdImageLight, soliderIdImageLight,
            deputyIdImageLight, emptyIdImage, emptyIdImage, emptyIdImage, deputyIdImageDark,
            soliderIdImageDark, soliderIdImageDark, emptyIdImage, soliderIdImageDark, soliderIdImageDark,
            soliderIdImageDark, soliderIdImageDark, generalIdImageDark, soliderIdImageDark, soliderIdImageDark,
    };

    public static Stack<Integer[]> historyStack = new Stack<>();

}
