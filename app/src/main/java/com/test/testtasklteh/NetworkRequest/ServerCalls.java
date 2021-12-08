package com.test.testtasklteh.NetworkRequest;

import com.test.testtasklteh.PhoneMaskUtils.PhoneMaskDataModel;
import com.test.testtasklteh.PostUserDataUtils.PostDataModel;
import com.test.testtasklteh.ListDataUtils.ListDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServerCalls {

    @POST("api/v1/auth")
    @FormUrlEncoded
    Call<PostDataModel> createPost(@Field("phone") String phone,
                                   @Field("password") String password);

    @GET("api/v1/phone_masks")
    Call<PhoneMaskDataModel> messages();

    @GET("api/v1/posts")
    Call<List<ListDataModel>> getCardItem();
}

