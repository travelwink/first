package com.travelwink.first.common.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * RESTFyl API 响应格式
 *
 * @author chris
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class ApiResult implements Serializable {

	@Serial
    private static final long serialVersionUID = 8004487252556526569L;

	/**
     * 响应码
     */
    private int code;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private Object data;

    /**
     * 响应时间
     */
    private LocalDateTime time;

    public ApiResult() {
        time  = LocalDateTime.now();
    }

    public static ApiResult result(boolean flag){
        if (flag){
            return ok();
        }
        return fail();
    }

    public static ApiResult result(ApiCode apiCode){
        return result(apiCode,null);
    }

    public static ApiResult result(ApiCode apiCode,Object data){
        return result(apiCode,null,data);
    }

    public static ApiResult result(ApiCode apiCode,String message,Object data){
        boolean success = apiCode.getCode() == ApiCode.SUCCESS.getCode();
        String apiMessage = apiCode.getMessage();
        if (StringUtils.isNotBlank(apiMessage)){
            message = apiMessage;
        }
        return (ApiResult) ApiResult.builder()
                .code(apiCode.getCode())
                .message(message)
                .data(data)
                .success(success)
                .time(LocalDateTime.now())
                .build();
    }

    public static ApiResult ok(){
        return ok(null);
    }

    public static ApiResult ok(Object data){
        return result(ApiCode.SUCCESS,data);
    }

    public static ApiResult ok(Object data,String message){
        return result(ApiCode.SUCCESS,message,data);
    }

    public static ApiResult okMap(String key,Object value){
        Map<String,Object> map = new HashMap<>(1);
        map.put(key,value);
        return ok(map);
    }

    public static ApiResult fail(ApiCode apiCode){
        return result(apiCode,null);
    }

    public static ApiResult fail(String message){
        return result(ApiCode.FAIL,message,null);

    }

    public static ApiResult fail(ApiCode apiCode,Object data){
        if (ApiCode.SUCCESS == apiCode){
            throw new RuntimeException("失败结果状态码不能为" + ApiCode.SUCCESS.getCode());
        }
        return result(apiCode,data);

    }

    public static  ApiResult fail(Integer errorCode,String message){
        return new ApiResult()
                .setSuccess(false)
                .setCode(errorCode)
                .setMessage(message);
    }

    public static ApiResult fail(String key,Object value){
        Map<String,Object> map = new HashMap<>(1);
        map.put(key,value);
        return result(ApiCode.FAIL,map);
    }

    public static ApiResult fail() {
        return fail(ApiCode.FAIL);
    }
}