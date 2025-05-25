package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    static final int PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.name + ":фиксированная цена " + PRICE;
    }
}
