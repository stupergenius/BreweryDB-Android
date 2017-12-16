package com.benstatertots.brewerydb.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bsnider on 11/18/17.
 */

public class SingleApiObject<T> extends BaseApiObject {
    @SerializedName("data")
    @Expose
    public T data;
}
