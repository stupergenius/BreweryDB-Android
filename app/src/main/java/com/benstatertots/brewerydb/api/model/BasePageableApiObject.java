package com.benstatertots.brewerydb.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bsnider on 11/18/17.
 */

public class BasePageableApiObject<T> extends BaseApiObject {
    @SerializedName("data")
    @Expose
    public List<T> data;

    @SerializedName("numberOfPages")
    @Expose
    public long numberOfPages;

    @SerializedName("currentPage")
    @Expose
    public long currentPage;
}
