package xyz.lixiangyu.leetcode.infrastructure.model.common;

import lombok.Data;

/**
 * @author lixiangyu
 */
@Data
public class RestResponse<T> {
    private T data;

    private Integer errorCode;

    private String errorMessage;

    public static <T> RestResponse<T> success(T data) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.setErrorCode(0);
        restResponse.setData(data);
        return restResponse;
    }

    public static <T> RestResponse<T> fail(T data, Integer errorCode) {
        return fail(data, errorCode, null);
    }

    public static <T> RestResponse<T> fail(T data, Integer errorCode, String errorMessage) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.setData(data);
        restResponse.setErrorCode(errorCode);
        restResponse.setErrorMessage(errorMessage);
        return restResponse;
    }
}
