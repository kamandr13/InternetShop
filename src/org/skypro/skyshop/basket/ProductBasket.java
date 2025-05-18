package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private static Product[] products;

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
            if (prod != null) {
                if (prod.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(products,null);
    }

    public String toSting() {
        String str = "";
        boolean isEmpty = true;
        for (Product prod : products) {
            if (prod != null) {
                str += prod + "\n";
                isEmpty = false;
            }
        }
        if (isEmpty) {
            return "В корзине пусто";
        } else {
            str += "Итого:" + this.total();
            return str;
        }
    }
}
