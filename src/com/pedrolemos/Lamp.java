package com.pedrolemos;

import com.pedrolemos.Genies.Genie;
import com.pedrolemos.Genies.RecyclableGenie;

public class Lamp {
    private static Lamp lamp = null;
    private GeniesFactory geniesFactory;
    private Genie currentGenie = null;

    private Lamp() {
        geniesFactory = new GeniesFactory();
    }

    public static Lamp getInstance() {
        if (lamp == null) {
            System.out.println("New Lamp Instantiated.");
            return lamp = new Lamp();
        }
        System.err.println("Returned already instantiated lamp.");
        return lamp;
    }

    protected Genie rub() {
        if (currentGenie != null) {
            if (currentGenie.getRemainingWishes() > 0) {
                System.out.println(currentGenie.getRemainingWishes());
                System.err.println("You cannot get a new Genie, as you still have " +
                        currentGenie.getRemainingWishes() + " wishes left.");

                return currentGenie;
            }
            if (geniesFactory.getGeniesInstantiated() == Values.MAX_GENIES) {
                resetRemainingGenies();
                return currentGenie = new RecyclableGenie();

            }
        }
        currentGenie = geniesFactory.getGenie();
        System.out.println("\r\nYou rubbed the lamp! " +
                "A new genie came out of the lamp! (" + currentGenie.getClass().getSimpleName() + ")");
        return currentGenie;
    }

    public void resetRemainingGenies(){
        geniesFactory.setGeniesInstantiated(0);
    }
}
