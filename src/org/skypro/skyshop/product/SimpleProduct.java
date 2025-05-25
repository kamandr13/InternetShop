package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    public String toString() {
        return super.name + ":" + this.price;
    }
}
