package com.example.theo1.nutripocket;

import android.util.Log;

import static java.lang.String.valueOf;

/**
 * Created by theod on 10/21/2017.
 */

public class calculateMacronutrientsGoal {

    static int carbsValueMax;
    static int protsValueMax;
    static int fatsValueMax;

    static double dcarbsValueMax;
    static double dprotsValueMax;
    static double dfatsValueMax;

    static String bodyType;
    static String sgoalAmount;
    static int goalAmount;


    calculateMacronutrientsGoal(String[] nutriuserInfo)
    {


        goalAmount = Integer.parseInt(nutriuserInfo[0]);
        bodyType = nutriuserInfo[1];


    }

    public static int[] calculate() {

        double carbRatio = 0;
        double protsRatio = 0;
        double fatsRatio = 0;

        final String firstLevel = "Ectomorph";
        final String secondLevel = "Mesomorph";
        final String thirdLevel = "Endomorph";

        switch (bodyType) {
            case firstLevel:
                carbRatio = .55;
                protsRatio = .25;
                fatsRatio = .2;
                break;
            case secondLevel:
                carbRatio = .4;
                protsRatio = .3;
                fatsRatio = .3;
                break;
            case thirdLevel:
                carbRatio = .25;
                protsRatio = .35;
                fatsRatio = .4;
                break;
        }

        dcarbsValueMax = ((goalAmount * carbRatio) / 4);
        Log.d("HELP", valueOf(dcarbsValueMax));
        dprotsValueMax = ((goalAmount * protsRatio) / 4);
        dfatsValueMax = ((goalAmount * fatsRatio) / 9);

        carbsValueMax = (int) dcarbsValueMax;
        Log.d("HELP", valueOf(carbsValueMax));
        protsValueMax = (int) dprotsValueMax;
        fatsValueMax = (int) dfatsValueMax;

        int[] returnInts = new int[] {carbsValueMax, protsValueMax, fatsValueMax};

        return returnInts;
    }


}
