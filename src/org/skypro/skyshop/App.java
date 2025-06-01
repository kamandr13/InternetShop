package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        Product apple = new SimpleProduct("Яблоко", 150);
        Product orange = new SimpleProduct("Апельсин", 200);
        Product milk = new DiscountedProduct("Молоко", 120, 20);
        Product bread = new DiscountedProduct("Хлеб", 60, 10);
        Product beer = new FixPriceProduct("Пиво");
        basket1.addProduct(apple);
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
