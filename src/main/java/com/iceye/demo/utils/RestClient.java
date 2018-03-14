package com.iceye.demo.utils;

import com.iceye.demo.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestClient {

    RestTemplate restTemplate;


    @Autowired
    PropertiesHolder propertiesHolder;

    public List<ResponseModel> fetchData() {
        restTemplate = new RestTemplate();
        final RestTemplate restTemplate = new RestTemplate();

        List<ResponseModel> responseList = new ArrayList<>();


        try {
            ResponseEntity<List<ResponseModel>> rateResponse = restTemplate.exchange(propertiesHolder.getUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<ResponseModel>>() {});
            responseList = rateResponse.getBody();
            return responseList;
        } catch (Exception exp) {
            exp.printStackTrace();
            return responseList;
        }
    }
}
