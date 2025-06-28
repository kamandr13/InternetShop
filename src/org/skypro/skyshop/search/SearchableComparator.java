package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lengthCompare = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return s1.getSearchTerm().compareTo(s2.getSearchTerm());
    }
}
