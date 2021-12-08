package com.test.testtasklteh.NetworkRequest;

import com.test.testtasklteh.PhoneMaskUtils.PhoneMaskDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.test.testtasklteh.Constans.BASE_URL_PHONE_MASK;

public abstract class ServerRequest {
     public abstract void createRequest();
}
