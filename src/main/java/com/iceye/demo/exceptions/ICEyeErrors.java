package com.iceye.demo.exceptions;

import org.springframework.http.HttpStatus;

public enum ICEyeErrors {



    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "file not found");


    private HttpStatus httpStatus;


    private String description;


    private ICEyeErrors(final HttpStatus httpStatus, final String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public ICEyeCustomException buildException() {
        return new ICEyeCustomException(this);
    }
}
