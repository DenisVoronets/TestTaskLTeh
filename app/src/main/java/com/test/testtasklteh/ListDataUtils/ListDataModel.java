package com.test.testtasklteh.ListDataUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListDataModel {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("text")
    @Expose
    private String description;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("date")
    @Expose
    private String date;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getSort() {
        return sort;
    }

    public String getDate() {
        return date;
    }
}
