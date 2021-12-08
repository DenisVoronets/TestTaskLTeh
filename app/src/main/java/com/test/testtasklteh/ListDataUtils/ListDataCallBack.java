package com.test.testtasklteh.ListDataUtils;

import com.test.testtasklteh.NetworkRequest.CallBack;

import java.util.List;

public interface ListDataCallBack extends CallBack {

    void isSuccess(List<ListDataModel> dataFromServers);
}
