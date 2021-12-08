package com.test.testtasklteh.PhoneMaskUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhoneMaskDataModel {
    @SerializedName("phoneMask")
    @Expose
    private String phoneMask;

    public String getPhoneMask() {
        return phoneMask;
    }

}
