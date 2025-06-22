package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new TreeMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProduct(String nameForRemove) throws EmptyBasket {
        List<Product> removedProducts = new LinkedList<>();
        if (products.containsKey(nameForRemove)) {
            removedProducts = products.get(nameForRemove);
            products.remove(nameForRemove);
        }
        if (removedProducts.isEmpty()) {
            throw new EmptyBasket();
        }
        return removedProducts;
    }

    public int total() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product prod : productList) {
                total += prod.getPrice();
            }
        }
        return total;
    }

    public boolean search(String name) {
        if (products.containsKey(name)) {
            return true;
        }
        return false;
    }

    public void clear() {
        products.clear();
    }

    public void printBasket() {
        boolean isEmpty = true;
        int isSpecialCount = 0;
        for (Map.Entry<String, List<Product>> m : products.entrySet()) {
            isEmpty = false;
            System.out.println(m.getKey() + " - " + m.getValue());
            for (Product prod : m.getValue()) {
                if (prod.isSpecial()) {
                    isSpecialCount++;
                }
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + this.total());
            System.out.println("Специальных товаров:" + isSpecialCount);
        }
    }
}
