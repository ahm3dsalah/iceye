package com.iceye.demo.controllers;

import com.iceye.demo.model.ResponseModel;
import com.iceye.demo.utils.RestClient;
import com.iceye.demo.utils.ReverseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("assignment")
public class AssigmentController {


    @Autowired
    RestClient restClient;
    @RequestMapping(method = RequestMethod.GET)
    public List<ResponseModel> serve(){
        List<ResponseModel> responseList =  restClient.fetchData();
        List<ResponseModel> reversed = responseList.stream().
                map(model -> ReverseHelper.reverse(model)).collect(Collectors.toList());
        return reversed;
    }
}
