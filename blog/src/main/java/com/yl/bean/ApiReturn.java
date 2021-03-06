package com.yl.bean;

import com.yl.enumerate.ReturnCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yi
 * @desciption api返回实体
 * @date 2019/11/18
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiReturn {

    private Integer code;
    private String msg;
    private Object data;

    public ApiReturn(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiReturn success(String msg, Object data) {
        return new ApiReturn(ReturnCode.SUCCESS.getCode(), msg, data);
    }

    public static ApiReturn success(String msg) {
        return success(msg, null);
    }

    public static ApiReturn fail(String msg) {
        return new ApiReturn(ReturnCode.FAIL.getCode(), msg);
    }
}
