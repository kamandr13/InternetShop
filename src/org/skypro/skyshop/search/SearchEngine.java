package org.skypro.skyshop.search;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchableList;

    public SearchEngine() {
        this.searchableList = new LinkedList<>();
    }

    public List<Searchable> search(String term) {
        List<Searchable> result = new LinkedList<>();
        for (Searchable el : searchableList) {
            if (el != null && el.getSearchTerm().contains(term)) {
                result.add(el);
            }
        }
        return result;
    }

    public void add(Searchable elem) {
        searchableList.add(elem);
    }

    public Searchable bestSearch(String term) throws BestResultNotFound {
        String lowerCaseTerm = term.toLowerCase();
        Searchable bestResult = null;
        int maxScore = 0;
        for (Searchable searchable : searchableList) {
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
