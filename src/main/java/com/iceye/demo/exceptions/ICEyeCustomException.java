package com.iceye.demo.exceptions;

public class ICEyeCustomException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4502333030494240113L;


    private ICEyeErrors iceyeErrors;

    public ICEyeErrors getIceyeErrors() {
        return iceyeErrors;
    }

    public void setIceyeErrors(ICEyeErrors iceyeErrors) {
        this.iceyeErrors = iceyeErrors;
    }

    public ICEyeCustomException(final ICEyeErrors IceyeErrors) {
        super(IceyeErrors.getDescription());
        this.iceyeErrors = IceyeErrors;
    }
}
