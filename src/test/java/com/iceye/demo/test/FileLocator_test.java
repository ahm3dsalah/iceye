package com.iceye.demo.test;

import com.iceye.demo.exceptions.ICEyeCustomException;
import com.iceye.demo.utils.FileLocator;
import com.iceye.demo.utils.ImageGenerator;
import com.iceye.demo.utils.PropertiesHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileLocator_test {

    private final static String FILE_NAME = "ABC";
    private final static String MESSAGE = "MESSAGE";
    private final static String FILE_EXTENSION  = ".png";
    private final static String NOT_FOUND_FILE = "NOT_FOUND_FILE_NAME";


    @Autowired
    PropertiesHolder propertiesHolder;

    @Autowired
    ImageGenerator imageGenerator;

    @Autowired
    FileLocator fileLocator;

    @Before
    public void setUp(){
        imageGenerator.createImage(MESSAGE, FILE_NAME);
    }

    @Test
    public void loadFile_test_success() {
        try {
            File file = new File(propertiesHolder.getFileRepository() + FILE_NAME + FILE_EXTENSION);
            boolean fileFound = file.exists();
            Assert.assertTrue(fileFound);
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }
    @Test(expected = ICEyeCustomException.class)
    public void loadFile_test_fail() throws FileNotFoundException {
        fileLocator.loadFile(NOT_FOUND_FILE);
    }
}
