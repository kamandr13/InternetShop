package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.EmptyBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
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
        Product beer1 = new DiscountedProduct("Пиво Балтика 1", 100, 10);
        Product beer2 = new FixPriceProduct("Пиво Балтика 22");
        Product beer3 = new FixPriceProduct("Пиво Балтика 333");
        Article bob = new Article("Губка", "Поролоновая губка, для мытья посуды губка");
        Article rag = new Article("Тряпка", "Ворсовая тряпка, для мытья полов");
        Article book1 = new Article("Воин на отшибе", "Заметка на злобу дня");
        Article book2 = new Article("Один в поле не воин", "Эпос");
        Article book3 = new Article("Супервоин", "Фантастика");

        ProductBasket basket = new ProductBasket();
        basket.printBasket();
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(bread);
        basket.addProduct(bread);
        basket.addProduct(beer3);
        basket.addProduct(beer2);
        basket.addProduct(beer1);
        basket.addProduct(apple);
        basket.addProduct(apple);
        basket.printBasket();

        try {
            System.out.println(basket.removeProduct("Яблоко"));
            basket.printBasket();
            System.out.println(basket.removeProduct("asdf"));
        } catch (EmptyBasket e) {
            System.out.println(e);
        }
        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(apple);
        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(beer1);
        searchEngine.add(beer2);
        searchEngine.add(beer3);
        searchEngine.add(bob);
        searchEngine.add(rag);
        searchEngine.add(book1);
        searchEngine.add(book2);
        searchEngine.add(book3);

        System.out.println("Демонстрация отсортированного поиска");
        System.out.println(searchEngine.search("Яблоко"));
        System.out.println(searchEngine.search("Пиво"));
        System.out.println(searchEngine.search("воин"));
    }
}

