package com.benstatertots.brewerydb.beer.list.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Labels {

    @SerializedName("medium")
    @Expose
    public String medium;
    @SerializedName("large")
    @Expose
    public String large;
    @SerializedName("icon")
    @Expose
    public String icon;
}
