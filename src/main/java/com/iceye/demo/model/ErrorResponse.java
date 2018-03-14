package com.iceye.demo.model;

public class ErrorResponse {
    private String description;

    /** The error. */
    private String error;

    /** The status. */
    private String status;

    public ErrorResponse(String description, String error, String status) {
        this.description = description;
        this.error = error;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
