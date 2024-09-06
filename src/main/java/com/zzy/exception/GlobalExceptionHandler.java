package com.zzy.exception;

import com.zzy.entity.resp.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = {BusinessException.class})
    @ResponseBody
    public <T> Resp<T> handleBusinessException(BusinessException e) {
        return Resp.fail(e);
    }
    
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public void handleException(Exception e) {
        log.error(e.getMessage(), e);
    }
    
}
