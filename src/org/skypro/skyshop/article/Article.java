package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private String name;
    private String text;

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
        return this.name + '\'' + this.text + '\'';
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
