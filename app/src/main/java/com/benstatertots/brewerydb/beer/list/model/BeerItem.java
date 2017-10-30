package com.benstatertots.brewerydb.beer.list.model;

/**
 * A dummy item representing a piece of content.
 */
public class BeerItem {
    public final String id;
    public final String title;
    public final String description;
    public final String imageUrl;

    public BeerItem(String id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
