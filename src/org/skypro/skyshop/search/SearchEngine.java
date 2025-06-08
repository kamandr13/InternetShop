package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchableArray;

    public SearchEngine(int size) {
        this.searchableArray = new Searchable[size];
    }

    public Searchable[] search(String term) {
        Searchable[] result = new Searchable[5];
        int t = 0;
        for (Searchable el : searchableArray) {
            if (el != null && el.getSearchTerm().contains(term) && t < result.length) {
                result[t] = el;
                t++;
            }
            if (t == result.length) break;
        }
        return result;
    }

    public void add(Searchable elem) {
        for (int i = 0; i < searchableArray.length; i++) {
            if (searchableArray[i] == null) {
                searchableArray[i] = elem;
                return;
            }
        }
    }

    public Searchable bestSearch(String term) throws BestResultNotFound {
        String lowerCaseTerm = term.toLowerCase();
        Searchable bestResult = null;
        int maxScore = 0;
        for (Searchable searchable : searchableArray) {
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
