package com.iceye.demo.utils;

import com.iceye.demo.exceptions.InvalidURLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class FileLocator {

    @Autowired
    ResourceReader resourceReader;
    public InputStreamResource loadFile(String fileName) {
        File file = new File(resourceReader.getFileRepository()+fileName+".png");

        try {

            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            return resource;
        } catch (FileNotFoundException fne){
            fne.printStackTrace();
            throw new InvalidURLException();
        }

    }

}
