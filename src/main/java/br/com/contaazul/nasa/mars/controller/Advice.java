package br.com.contaazul.nasa.mars.controller;

import com.google.common.base.Throwables;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by maveco on 14/06/17.
 */
@ControllerAdvice
public class Advice {

    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError exception(Exception exception, WebRequest request) {
        return new ApiError(Throwables.getRootCause(exception).getMessage());
    }

}
