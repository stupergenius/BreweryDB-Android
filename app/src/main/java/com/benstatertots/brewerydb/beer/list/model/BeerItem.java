package com.benstatertots.brewerydb.beer.list.model;

import com.google.gson.annotations.*;

public class BeerItem {

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("abv")
    @Expose
    public String abv;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("styleId")
    @Expose
    public long styleId;

    @SerializedName("style")
    @Expose
    public Style style;

    @SerializedName("labels")
    @Expose
    public Labels labels;

    @SerializedName("glasswareId")
    @Expose
    public long glasswareId;

    @SerializedName("glass")
    @Expose
    public Glass glass;

    @SerializedName("isOrganic")
    @Expose
    public String isOrganic;

    @SerializedName("createDate")
    @Expose
    public String createDate;

    @SerializedName("updateDate")
    @Expose
    public String updateDate;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("statusDisplay")
    @Expose
    public String statusDisplay;
}

