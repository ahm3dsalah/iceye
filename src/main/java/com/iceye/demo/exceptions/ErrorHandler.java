package com.iceye.demo.exceptions;



import com.iceye.demo.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Ahmed salah.
 */
@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ICEyeCustomException.class)
    public final ResponseEntity<ErrorResponse> handleException(final ICEyeCustomException exception) {
        final ICEyeErrors icEyeErrors = exception.getIceyeErrors();
        final ErrorResponse errorResponse = new ErrorResponse(icEyeErrors.getDescription(),
                icEyeErrors.name(),
                icEyeErrors.getHttpStatus().value());

        return new ResponseEntity<ErrorResponse>(errorResponse, icEyeErrors.getHttpStatus());
    }
}
