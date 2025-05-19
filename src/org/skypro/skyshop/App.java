package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        Product apple = new Product("Яблоко", 150);
        Product pear = new Product("Груша", 250);
        Product orange = new Product("Апельсин", 200);
        Product milk = new Product("Молоко", 120);
        Product bread = new Product("Хлеб", 60);
        Product beer = new Product("Пиво", 150);
        basket1.addProduct(apple);
        basket1.addProduct(pear);
        basket1.addProduct(orange);
        basket1.addProduct(milk);
        basket1.addProduct(bread);
        basket1.addProduct(beer);
        basket1.print();
        System.out.println("Итоговая стоимость корзины:" + basket1.total());
        searchProduct(basket1, "Яблоко");
        searchProduct(basket1, "Пиво");
        basket1.clear();
        basket1.print();
        System.out.println("Итоговая стоимость корзины:" + basket1.total());
        searchProduct(basket1, "Яблоко");
    }

    public static void searchProduct(ProductBasket basket, String name) {
        if (basket.search(name)) {
            System.out.println("В корзине есть " + name);
        } else {
            System.out.println("В корзине нет " + name);
        }
    }
}
