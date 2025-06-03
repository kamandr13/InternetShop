package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private int percentDiscount;

    public DiscountedProduct(String name, int basicPrice, int percentDiscount) {
        super(name);
        this.basicPrice = basicPrice;
        this.percentDiscount = percentDiscount;
    }

    @Override
    public int getPrice() {
        return basicPrice - basicPrice * percentDiscount / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return this.getName() + ":" + getPrice() + "(" + this.percentDiscount + "%)";
    }
}
