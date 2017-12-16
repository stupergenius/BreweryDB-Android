package com.benstatertots.brewerydb.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bsnider on 11/18/17.
 */
public class Category {

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
