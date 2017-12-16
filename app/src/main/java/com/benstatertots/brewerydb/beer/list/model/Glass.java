package com.benstatertots.brewerydb.beer.list.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Glass {

    @SerializedName("id")
    @Expose
    public long id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("createDate")
    @Expose
    public String createDate;
}
