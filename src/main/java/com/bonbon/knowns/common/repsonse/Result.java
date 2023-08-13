package com.bonbon.knowns.common.repsonse;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author jiazhiyuan
 * @date 2023/8/5 10:22 AM
 */

@Data
public class Result {

    private Boolean success;

    private Integer code;

    private String message;

    private Object data;

    /**
     *
     */
    private String ipAddress;


    private String traceId;


    private String hostName;


    public Result(Boolean success, Integer code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result OK() {
        return new Result(true, 200, null, null);
    }

    public static  Result OK(Object data) {
        return new Result (true, 200, null, data);
    }


    public static Result fail(String message) {
        return new Result(false, 500, message, null);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}



    
