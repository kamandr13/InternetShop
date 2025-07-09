package org.skypro.skyshop.search;

public class SearchableOccurScore {
    final Searchable searchable;
    final int occurScore;

    SearchableOccurScore(Searchable searchable, int occurScore) {
        this.searchable = searchable;
        this.occurScore = occurScore;
    }
}
