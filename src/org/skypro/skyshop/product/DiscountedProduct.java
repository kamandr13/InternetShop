package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    final int basicPrice;
    int percentDiscount;

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
        return super.name + ":" + getPrice() + "(" + this.percentDiscount + "%)";
    }
}
