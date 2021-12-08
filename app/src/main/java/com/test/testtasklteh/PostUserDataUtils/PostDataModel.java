package com.test.testtasklteh.PostUserDataUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostDataModel {
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("success")
    @Expose
    private boolean success;

    public PostDataModel(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
