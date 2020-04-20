/**
 * Rules:
 * Releases a new genie every time it is rubbed
 * When enchanted (instantiated), maximum number genies is set
 * Genies can be Friendly (even) or Grumpy (odd)
 * When number of genies is exhausted, releases a recyclable demon
 * Has the ability to recycle a demon and recharge itself
 */

package com.pedrolemos;

import com.pedrolemos.Genies.Genie;
import com.pedrolemos.Genies.RecyclableGenie;

public class Main {
    private static Genie currentGenie;
    private static Lamp lamp;

    public static void main(String[] args) {
        doActions();
    }

    private static void doActions() {
        lamp = Lamp.getInstance(); //Singleton
        lamp = Lamp.getInstance();
        //Lamp.getInstance(); //returns same lamp.

        round(); //round1 until recyclable
        System.out.println("============== ROUND 2 ================");
        round(); //round2
    }

    private static void grantThreeWishes(){
        for (int i = 0; i < 3; i++) {
            currentGenie.grantWish();
        }
    }

    private static void round() {
        currentGenie = lamp.rub();
        grantThreeWishes();
        currentGenie.grantWish(); //will fail.
        currentGenie = lamp.rub();
        grantThreeWishes();
        currentGenie.recycle(); //will fail
        currentGenie = lamp.rub();
        grantThreeWishes();
        currentGenie = lamp.rub(); //unleashes Recyclable
        grantThreeWishes();
        currentGenie.recycle(); //will recycle
    }
}
