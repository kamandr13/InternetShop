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
        int total = products.values().stream().flatMap(Collection::stream)
                .mapToInt(p -> p.getPrice())
                .sum();
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

    public long getSpecialCount() {
        return products.values().stream().flatMap(Collection::stream)
                .filter(p -> p.isSpecial())
                .count();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            products.entrySet().stream()
                    .forEach(p -> System.out.println(p.getKey() + " - " + p.getValue()));
            System.out.println("Итого: " + this.total());
            System.out.println("Специальных товаров:" + this.getSpecialCount());
        }
    }
}
