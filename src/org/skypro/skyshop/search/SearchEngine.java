package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchableSet;

    public SearchEngine() {
        this.searchableSet = new HashSet<>();
    }

    public Set<Searchable> search(String term) {
        Set<Searchable> result = new TreeSet<>(new SearchableComparator());
        for (Searchable el : searchableSet) {
            if (el.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                result.add(el);
            }
        }
        return result;
    }

    public void add(Searchable elem) {
        searchableSet.add(elem);
    }

    public Searchable bestSearch(String term) throws BestResultNotFound {
        String lowerCaseTerm = term.toLowerCase();
        Searchable bestResult = null;
        int maxScore = 0;
        for (Searchable searchable : searchableSet) {
            if (searchable != null) {
                int score = 0;
                int index = 0;
                String searchTerm = searchable.getSearchTerm().toLowerCase();
                int subStrIndex = searchTerm.indexOf(lowerCaseTerm, index);
                while (subStrIndex != -1) {
                    score++;
                    index = subStrIndex + term.length();
                    subStrIndex = searchTerm.indexOf(lowerCaseTerm, index);
                }
                if (score > maxScore) {
                    maxScore = score;
                    bestResult = searchable;
                }
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound(term);
        }
        return bestResult;
    }
}
