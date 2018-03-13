package com.iceye.demo.utils;

import com.iceye.demo.exceptions.InvalidURLException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class FileLocator {

    public InputStreamResource loadFile(String fileName) {
        File file = new File("/home/ahmed/MyWorkSpace/iceye/demo/"+fileName+".png");

        try {

            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            return resource;
        } catch (FileNotFoundException fne){
            throw new InvalidURLException();
        }

    }

}
