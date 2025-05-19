package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] products;

    public ProductBasket() {
        products = new Product[5];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
            if (i == products.length - 1) {
                System.out.println("Невозможно добавить продукт");
            }
        }
    }

    public int total() {
        int total = 0;
        for (Product prod : products) {
            if (prod != null) {
                total += prod.getPrice();
            }
        }
        return total;
    }

    public boolean search(String name) {
        for (Product prod : products) {
            if (prod != null && prod.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public void clear() {
        Arrays.fill(products, null);
    }

    public void print() {
        boolean isEmpty = true;
        for (Product prod : products) {
            if (prod != null) {
                System.out.println(prod);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого:" + this.total());
        }
    }
}
