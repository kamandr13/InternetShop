package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine(15);
        Product apple = new SimpleProduct("Яблоко", 150);
        Product orange = new SimpleProduct("Апельсин", 200);
        Product milk = new DiscountedProduct("Молоко", 120, 20);
        Product bread = new DiscountedProduct("Хлеб", 60, 10);
        Product beer = new FixPriceProduct("Пиво");
        Article bob = new Article("Губка", "Поролоновая, для мытья посуды");
        Article rag = new Article("Тряпка", "Ворсовая, для мытья полов");
        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(beer);
        searchEngine.add(bob);
        searchEngine.add(rag);
        System.out.println(Arrays.toString(searchEngine.search("Губка")));
        System.out.println(Arrays.toString(searchEngine.search("блоко")));
        System.out.println(Arrays.toString(searchEngine.search("мытья")));
    }

    public static void searchProduct(ProductBasket basket, String name) {
        if (basket.search(name)) {
            System.out.println("В корзине есть " + name);
        } else {
            System.out.println("В корзине нет " + name);
        }
    }
}
