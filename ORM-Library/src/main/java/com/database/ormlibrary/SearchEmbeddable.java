package com.database.ormlibrary;

import javax.persistence.Embeddable;

@Embeddable
public class SearchEmbeddable {
    private String searchPrimary; //term,term,term
    private String searchSecondary; //term,term,term

    @Override
    public String toString() {
        return "SearchEmbeddable{" +
                "searchPrimary='" + searchPrimary + '\'' +
                ", searchSecondary='" + searchSecondary + '\'' +
                '}';
    }

    public String getSearchPrimary() {
        return searchPrimary;
    }

    public SearchEmbeddable setSearchPrimary(String searchPrimary) {
        this.searchPrimary = searchPrimary;
        return this;
    }

    public String getSearchSecondary() {
        return searchSecondary;
    }

    public SearchEmbeddable setSearchSecondary(String searchSecondary) {
        this.searchSecondary = searchSecondary;
        return this;
    }
}
