package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchableSet;

    public SearchEngine() {
        this.searchableSet = new HashSet<>();
    }

    public Set<Searchable> search(String term) {
        Set<Searchable> result = searchableSet.stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(term.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
        return result;
    }

    public void add(Searchable elem) {
        searchableSet.add(elem);
    }

    public Searchable bestSearch(String term) throws BestResultNotFound {
        String lowerCaseTerm = term.toLowerCase();
        return searchableSet.stream()
                .filter(Objects::nonNull)
                .map(searchable -> new SearchableOccurScore(searchable, countOccurScore(searchable.getSearchTerm().toLowerCase(), lowerCaseTerm)))
                .filter(o -> o.occurScore > 0)
                .max(Comparator.comparingInt(o -> o.occurScore))
                .map(o -> o.searchable)
                .orElseThrow(() -> new BestResultNotFound(term));
    }

    private int countOccurScore(String text, String pattern) {
        int occurScore = 0;
        int index = 0;
        while ((index = text.indexOf(pattern, index)) != -1) {
            occurScore++;
            index += pattern.length();
        }
        return occurScore;
    }
}
