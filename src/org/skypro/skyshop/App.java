package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.EmptyBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {
        Product apple = null;
        Product milk = null;
        try {
            milk = new DiscountedProduct("Молоко", 120, 20);
            apple = new SimpleProduct("Яблоко", 90);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании товара: " + e.getMessage());
        }
        Product bread = new DiscountedProduct("Хлеб", 60, 10);
        Product beer1 = new DiscountedProduct("Пиво Балтика 3", 100, 10);
        Product beer2 = new FixPriceProduct("Пиво Балтика 7");
        Product beer3 = new FixPriceProduct("Пиво Балтика 9");
        Article bob = new Article("Губка", "Поролоновая губка, для мытья посуды губка");
        Article rag = new Article("Тряпка", "Ворсовая тряпка, для мытья полов");

        System.out.println("1. Изменение используемой структуры данных в классе ProductBasket");
        ProductBasket basket = new ProductBasket();
        basket.addProduct(milk);
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(beer1);
        basket.addProduct(beer2);
        basket.addProduct(beer3);
        basket.addProduct(apple);
        basket.printBasket();

        System.out.println("2. Добавление метода удаления продукта по имени из корзины");
        try {
            System.out.println(basket.removeProduct("Яблоко"));
            basket.printBasket();
            System.out.println(basket.removeProduct("asdf"));
        } catch (EmptyBasket e) {
            System.out.println(e);
        }
        basket.printBasket();

        System.out.println("3. Изменение используемой структуры данных в классе SearchEngine");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(beer1);
        searchEngine.add(beer2);
        searchEngine.add(beer3);
        searchEngine.add(bob);
        searchEngine.add(rag);
        System.out.println(searchEngine.search("Пиво"));
        System.out.println(searchEngine.search("губка"));
        System.out.println(searchEngine.search("asdf"));
    }
}
