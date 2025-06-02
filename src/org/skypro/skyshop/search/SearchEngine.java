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
            if (el != null && el.getSearchTerm().contains(term)) {
                result[t] = el;
                System.out.println(result[t].getStringRepresentation());
                t++;
            }
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
}
