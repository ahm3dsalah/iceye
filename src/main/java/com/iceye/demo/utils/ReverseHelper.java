package com.iceye.demo.utils;

import com.iceye.demo.model.ResponseModel;

public class ReverseHelper {

    public static ResponseModel reverse(final ResponseModel responseModel) {

        ResponseModel reversed = new ResponseModel();
        reversed.setUserId(responseModel.getUserId());
        reversed.setId(responseModel.getId());
        reversed.setBody(new StringBuilder(responseModel.getBody()).reverse().toString());
        reversed.setTitle(new StringBuilder(responseModel.getTitle()).reverse().toString());

        return reversed;
    }
}
