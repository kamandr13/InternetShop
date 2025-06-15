package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if(price<1) {
            throw new IllegalArgumentException("Цена продукта меньше 1");
        }
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
        return this.getName() + ":" + this.price;
    }
}
