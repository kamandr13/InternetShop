package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(15);
        Product apple = null;
        Product milk = null;
        try {
            apple = new SimpleProduct(null, 0);
            milk = new DiscountedProduct("Молоко", 120, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании товара: " + e.getMessage());
        }
        Product bread = new DiscountedProduct("Хлеб", 60, 10);
        Product beer = new FixPriceProduct("Пиво");
        Article bob = new Article("Губка", "Поролоновая губка, для мытья посуды губка");
        Article rag = new Article("Тряпка", "Ворсовая тряпка, для мытья полов");
        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(beer);
        searchEngine.add(bob);
        searchEngine.add(rag);
        try {
            System.out.println(searchEngine.bestSearch("Пиво"));
            System.out.println(searchEngine.bestSearch("губка"));
            System.out.println(searchEngine.bestSearch("asdf"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
    }

    public static void searchProduct(ProductBasket basket, String name) {
        if (basket.search(name)) {
            System.out.println("В корзине есть " + name);
        } else {
            System.out.println("В корзине нет " + name);
        }
    }
}
