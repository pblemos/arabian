package com.pedrolemos.Genies;

public class RecyclableGenie extends Genie {
    public static boolean recycled = false;

    public RecyclableGenie(){
        System.out.println("\r\nYou unleashed a Recyclable Genie");
    }

    @Override
    public String getGrantWishMessage() {
        return "The opposite wish was granted...";
    }

    @Override
    public void grantWish() {
        if (!recycled) {
            super.grantWish();
        } else {
            System.out.println("I was recycled. I can't be recycled anymore and I don't have any more wishes. The end.");
        }
    }
}
