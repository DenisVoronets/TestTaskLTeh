package com.test.testtasklteh.PostUserDataUtils;

import com.test.testtasklteh.NetworkRequest.ServerCalls;
import com.test.testtasklteh.NetworkRequest.RetrofitClient;
import com.test.testtasklteh.NetworkRequest.ServerRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.test.testtasklteh.Constans.BASE_URL_PHONE_MASK;

public class PostRequest extends ServerRequest {
    private String phone;
    private String password;
    private PostCallBack postCallBack;

    public PostRequest(String phone, String password, PostCallBack postCallBack) {
        this.phone = phone;
        this.password = password;
        this.postCallBack = postCallBack;
    }

    @Override
    public void createRequest() {
        ServerCalls postCall = RetrofitClient.getClient(BASE_URL_PHONE_MASK).create(ServerCalls.class);
        Call<PostDataModel> call = postCall.createPost(phone, password);
        call.enqueue(new Callback<PostDataModel>() {
            @Override
            public void onResponse(Call<PostDataModel> call, Response<PostDataModel> response) {
                if (response.isSuccessful()) {
                    PostDataModel postDataModel = response.body();
                    postCallBack.isSuccess(postDataModel.isSuccess());
                } else {
                    postCallBack.onError("Error");
                }
            }

            @Override
            public void onFailure(Call<PostDataModel> call, Throwable t) {
                postCallBack.onError(t.toString());
            }
        });
    }
}
