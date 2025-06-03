package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> removeProduct(String nameForRemove) throws EmptyBasket {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product prod = iterator.next();
            if (prod.getName().equals(nameForRemove)) {
                removedProducts.add(prod);
                iterator.remove();
            }
        }
        if (removedProducts.isEmpty()) {
            throw new EmptyBasket();
        }
        return removedProducts;
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
        products.clear();
    }

    public void printBasket() {
        boolean isEmpty = true;
        int isSpecialCount = 0;
        for (Product prod : products) {
            if (prod != null) {
                System.out.println(prod);
                isEmpty = false;
                if (prod.isSpecial()) {
                    isSpecialCount++;
                }
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого:" + this.total());
            System.out.println("Специальных товаров:" + isSpecialCount);
        }
    }
}
