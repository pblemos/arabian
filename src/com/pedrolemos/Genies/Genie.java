package com.pedrolemos.Genies;
import com.pedrolemos.Values;

public abstract class Genie {
    int remainingWishes = Values.MAX_WISHES;

    public int getRemainingWishes() {
        return remainingWishes;
    }

    public abstract String getGrantWishMessage();

    public void grantWish() {
        if (remainingWishes > 0) {
            remainingWishes--;
            System.out.println(this.getGrantWishMessage() + " You still have " + getRemainingWishes() + " wishes left.");
            return;
        }
        System.out.println("This genie doesn't have any more wishes.");
    }

    public void recycle(){
        if (this instanceof RecyclableGenie) {
            if (RecyclableGenie.recycled) {
                System.out.println("Genie was already recycled, and can't be recycled again.");
                return;
            }
            System.out.println("Genie recycled.");
            RecyclableGenie.recycled = true;
            return;
        }
        System.out.println("This genie can't be recycled, as it's a " + this.getClass().getSimpleName());
    }
}
