package com.test.testtasklteh.ListDataUtils;

import com.test.testtasklteh.NetworkRequest.RetrofitClient;
import com.test.testtasklteh.NetworkRequest.ServerCalls;
import com.test.testtasklteh.NetworkRequest.ServerRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.test.testtasklteh.Constans.BASE_URL_PHONE_MASK;

public class ListDataRequest extends ServerRequest {
    private ListDataCallBack serverDataCallBack;

    public ListDataRequest(ListDataCallBack serverDataCallBack) {
        this.serverDataCallBack = serverDataCallBack;
    }

    @Override
    public void createRequest() {
        ServerCalls dataFromServerCall = RetrofitClient.getClient(BASE_URL_PHONE_MASK).create(ServerCalls.class);
        Call<List<ListDataModel>> call = dataFromServerCall.getCardItem();
        call.enqueue(new Callback<List<ListDataModel>>() {
            @Override
            public void onResponse(Call<List<ListDataModel>> call, Response<List<ListDataModel>> response) {
                if (response.isSuccessful()) {
                    List<ListDataModel> dataList = response.body();
                    serverDataCallBack.isSuccess(dataList);
                } else {
                    serverDataCallBack.onError("Error");
                }
            }

            @Override
            public void onFailure(Call<List<ListDataModel>> call, Throwable t) {
                serverDataCallBack.onError(t.toString());
            }
        });
    }
}
