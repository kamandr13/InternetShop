package org.skypro.skyshop.search;

import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private Map<String, Searchable> searchableMap;

    public SearchEngine() {
        this.searchableMap = new TreeMap<>();
    }

    public Map<String, Searchable> search(String term) {
        Map<String, Searchable> result = new TreeMap<>();
        for (Map.Entry<String, Searchable> el : searchableMap.entrySet()) {
            if (el != null && el.getValue().getSearchTerm().contains(term)) {
                result.put(el.getValue().getName(), el.getValue());
            }
        }
        return result;
    }

    public void add(Searchable elem) {
        searchableMap.put(elem.getName(), elem);
    }

    public Searchable bestSearch(String term) throws BestResultNotFound {
        String lowerCaseTerm = term.toLowerCase();
        Searchable bestResult = null;
        int maxScore = 0;
        for (Searchable searchable : searchableMap.values()) {
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
