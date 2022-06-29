package com.xc.advice;

import com.xc.model.response.ResponseDTO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @Author cuilb
 * @Data 2022 06 29 10:24
 * @Description
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public String handler() {
        return "hahahaha";
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseDTO<String> validExceptionHandler(MethodArgumentNotValidException exception) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(exception.getParameter().getMethod()).append("||");
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        allErrors.forEach(error -> stringBuffer.append(error.getDefaultMessage()).append(";"));
        return ResponseDTO.failed(stringBuffer.toString());
    }

}
