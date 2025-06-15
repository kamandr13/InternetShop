package org.skypro.skyshop.basket;

public class EmptyBasket extends Exception {

    public EmptyBasket() {
    }

    @Override
    public String toString() {
        return "Список пуст";
    }
}
