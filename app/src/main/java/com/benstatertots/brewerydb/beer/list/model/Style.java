package com.benstatertots.brewerydb.beer.list.model;

import com.benstatertots.brewerydb.api.model.Category;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Style {

    @SerializedName("id")
    @Expose
    public long id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("category")
    @Expose
    public Category category;

    @SerializedName("srmMax")
    @Expose
    public String srmMax;

    @SerializedName("ibuMax")
    @Expose
    public String ibuMax;

    @SerializedName("srmMin")
    @Expose
    public String srmMin;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("fgMin")
    @Expose
    public String fgMin;

    @SerializedName("ibuMin")
    @Expose
    public String ibuMin;

    @SerializedName("createDate")
    @Expose
    public String createDate;

    @SerializedName("fgMax")
    @Expose
    public String fgMax;

    @SerializedName("abvMax")
    @Expose
    public String abvMax;

    @SerializedName("ogMin")
    @Expose
    public String ogMin;

    @SerializedName("abvMin")
    @Expose
    public String abvMin;

    @SerializedName("categoryId")
    @Expose
    public long categoryId;

}
