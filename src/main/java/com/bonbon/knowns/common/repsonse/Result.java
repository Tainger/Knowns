package com.bonbon.knowns.common.repsonse;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author jiazhiyuan
 * @date 2023/8/5 10:22 AM
 */
public class Result<T> {

    /**
     * 请求唯一ID
     */
    private String requestId;

    private Boolean success;

    private Integer code;

    private String message;

    private T data;


    public Result(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result<Void> OK() {
        return new Result<>(true, 200, null, null);
    }

    public static <T> Result<T> OK(T data) {
        return new Result<T>(true, 200, null, data);
    }


    public Result<T> fail(String message) {
        return new Result<T>(false, 500, message, null);
    }


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}



    
