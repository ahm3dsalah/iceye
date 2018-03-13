package com.iceye.demo.controllers;

import com.iceye.demo.exceptions.InvalidURLException;
import com.iceye.demo.model.IngestRequestModel;
import com.iceye.demo.model.IngestResponseModel;
import com.iceye.demo.utils.ImageGenerator;
import com.iceye.demo.utils.ResourceReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


@RestController
public class IngestController {

    @Autowired
    ImageGenerator imageGenerator;

    @Autowired
    ResourceReader resourceReader;
    @RequestMapping(path = "ingest", method = RequestMethod.POST)
    public IngestResponseModel ingest(@RequestBody IngestRequestModel ingestRequestModel){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        imageGenerator.createImage(ingestRequestModel.getMessage(), generatedString);
        IngestResponseModel responseModel = new IngestResponseModel();
        responseModel.setDownloadUrl(resourceReader.getBaseDownloadUrl()+generatedString);
        return responseModel;
    }

    @RequestMapping(path = "/download/{fileName}", method = RequestMethod.GET)
    public ResponseEntity<Resource> download(@PathVariable String fileName){

        File file = new File("/home/ahmed/MyWorkSpace/iceye/demo/"+fileName+".png");
        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (FileNotFoundException fne){
            throw new InvalidURLException();
        }
    }
}