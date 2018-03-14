package com.iceye.demo.test;

import com.iceye.demo.utils.ImageGenerator;
import com.iceye.demo.utils.PropertiesHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageGenerator_test {


    private final static String FILE_NAME = "ABC";
    private final static String MESSAGE = "MESSAGE";
    private final static String FILE_EXTENSION  = ".png";

    @Autowired
    PropertiesHolder propertiesHolder;

    @Autowired
    ImageGenerator imageGenerator;

    @Before
    public void setUp(){
        // generate Image
        imageGenerator.createImage(MESSAGE, FILE_NAME);
    }

    @Test
    public void createImage_success() {
        try {
            Thread.sleep(2000);
            File file = new File(propertiesHolder.getFileRepository() + FILE_NAME + FILE_EXTENSION);
            boolean fileFound = file.exists();
            Assert.assertTrue(fileFound);
        } catch (Exception e) {

        }
    }
}
