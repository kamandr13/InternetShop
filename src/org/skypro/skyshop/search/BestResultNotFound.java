package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    String term;

    public BestResultNotFound(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Не найден результат по поисковый запросу: " + term;
    }
}
