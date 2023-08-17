package com.travelwink.first.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * RESTFul API Response Format
 *
 * @author chris
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class ApiResp<T> implements Serializable {

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
    private T data;

    /**
     * 响应时间
     */
    private LocalDateTime time;

    public ApiResp() {
        time  = LocalDateTime.now();
    }

    public static ApiResp<Boolean> result(boolean flag){
        if (flag){
            return ok();
        }
        return fail();
    }

    public static ApiResp<Boolean> result(ApiCode apiCode){
        return result(apiCode,null);
    }

    public static <T> ApiResp<T> result(ApiCode apiCode, T data){
        return result(apiCode,null,data);
    }

    public static <T> ApiResp<T> result(ApiCode apiCode, String message, T data){
        boolean success = apiCode.getCode() == ApiCode.SUCCESS.getCode();
        String apiMessage = apiCode.getMessage();
        if (StringUtils.isBlank(message)){
            message = apiMessage;
        }
        return (ApiResp<T>) ApiResp.builder()
                .code(apiCode.getCode())
                .message(message)
                .data(data)
                .success(success)
                .time(LocalDateTime.now())
                .build();
    }

    public static ApiResp<Boolean> ok(){
        return ok(null);
    }

    public static <T> ApiResp<T> ok(T data){
        return result(ApiCode.SUCCESS,data);
    }

    public static <T> ApiResp<T> ok(T data, String message){
        return result(ApiCode.SUCCESS,message,data);
    }

    public static <T> ApiResp<Map<String, T>> okMap(String key, T value){
        Map<String,T> map = new HashMap<>(1);
        map.put(key,value);
        return ok(map);
    }

    public static ApiResp<Boolean> fail() {
        return fail(ApiCode.FAIL);
    }

    public static ApiResp<Boolean> fail(ApiCode apiCode){
        return result(apiCode,null);
    }

    public static ApiResp<String> fail(String message){
        return result(ApiCode.FAIL,message,null);

    }

    public static <T> ApiResp<T> fail(ApiCode apiCode, T data){
        if (ApiCode.SUCCESS == apiCode){
            throw new RuntimeException("失败结果状态码不能为" + ApiCode.SUCCESS.getCode());
        }
        return result(apiCode,data);

    }

    public static <T> ApiResp<T> fail(Integer errorCode, String message){
        return (ApiResp<T>) ApiResp.builder()
                .success(false)
                .code(errorCode)
                .message(message).build();
    }

    public static <T> ApiResp<Map<String,T>> fail(String key, T value){
        Map<String,T> map = new HashMap<>(1);
        map.put(key,value);
        return result(ApiCode.FAIL,map);
    }

}