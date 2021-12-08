package com.test.testtasklteh.PhoneMaskUtils;

import com.test.testtasklteh.NetworkRequest.RetrofitClient;
import com.test.testtasklteh.NetworkRequest.ServerCalls;
import com.test.testtasklteh.NetworkRequest.ServerRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.test.testtasklteh.Constans.BASE_URL_PHONE_MASK;

public class PhoneMaskRequest extends ServerRequest {
    private PhoneMaskCallBack phoneMaskCallBack;

    public PhoneMaskRequest(PhoneMaskCallBack phoneMaskCallBack) {
        this.phoneMaskCallBack = phoneMaskCallBack;
    }

     public void createRequest() {
        ServerCalls serverCalls = RetrofitClient.getClient(BASE_URL_PHONE_MASK).create(ServerCalls.class);
        Call<PhoneMaskDataModel> call = serverCalls.messages();
        call.enqueue(new Callback<PhoneMaskDataModel>() {
            @Override
            public void onResponse(Call<PhoneMaskDataModel> call, Response<PhoneMaskDataModel> response) {
                if (response.isSuccessful()) {
                    phoneMaskCallBack.isSuccess(response.body().getPhoneMask());
                } else {
                    phoneMaskCallBack.onError("Error");
                }
            }

            @Override
            public void onFailure(Call<PhoneMaskDataModel> call, Throwable t) {
                phoneMaskCallBack.onError(t.toString());
            }
        });
    }
}
