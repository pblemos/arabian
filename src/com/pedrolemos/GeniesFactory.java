package com.pedrolemos;
import com.pedrolemos.Genies.*;

public class GeniesFactory {
    private int geniesInstantiated = 0;

    public Genie getGenie() {
        if ((geniesInstantiated+1) % 2 == 0) { //Even
            geniesInstantiated++;
            return new GrumpyGenie();
        }

        geniesInstantiated++;
        return new FriendlyGenie(); //Odd
    }

    public void setGeniesInstantiated(int geniesInstantiated) {
        this.geniesInstantiated = geniesInstantiated;
    }

    public int getGeniesInstantiated() {
        return geniesInstantiated;
    }

}
