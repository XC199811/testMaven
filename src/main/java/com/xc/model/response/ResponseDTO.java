package com.xc.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author cuilb
 * @Data 2022 06 28 11:33
 * @Description
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> ResponseDTO<T> ok(T data) {
        return new ResponseDTO<T>(200, "success", data);
    }

    public static <T> ResponseDTO<T> failed(T data) {
        return new ResponseDTO<>(500, "error", data);
    }

}
