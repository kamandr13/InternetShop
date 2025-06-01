package org.skypro.skyshop.product;

public abstract class Product {
    final String name;
    //private final int price;

    public Product(String name) {
        this.name = name;
        //this.price = price;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String toString() {
        return this.name;
    }
}
