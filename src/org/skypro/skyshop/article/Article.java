package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }


    @Override
    public String toString() {
        return this.name + '\n' + this.text;
    }

    @Override
    public String getSearchTerm() {
        return this.getName() + " " + this.getText();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
