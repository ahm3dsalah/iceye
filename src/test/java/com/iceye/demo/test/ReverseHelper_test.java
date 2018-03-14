package com.iceye.demo.test;

import com.iceye.demo.model.ResponseModel;
import com.iceye.demo.utils.ReverseHelper;
import org.junit.Assert;
import org.junit.Test;

public class ReverseHelper_test {

    private final static int USER_ID = 100;
    private final static int ID = 0;
    private final static String ORIGINAL_TITLE = "12345";
    private final static String REVERSED_TITLE = "54321";

    private final static String ORIGINAL_BODY = "qwerty";
    private final static String REVERSED_BODY = "ytrewq";

    @Test
    public void reverse_test() {
        ResponseModel original = new ResponseModel();
        original.setUserId(USER_ID);
        original.setId(ID);
        original.setBody(ORIGINAL_BODY);
        original.setTitle(ORIGINAL_TITLE);

        ResponseModel reversed = ReverseHelper.reverse(original);

        String reversedTitle = reversed.getTitle();
        String reversedBody = reversed.getBody();

        Assert.assertEquals(reversedTitle, REVERSED_TITLE);
        Assert.assertEquals(reversedBody, REVERSED_BODY);

    }
}
