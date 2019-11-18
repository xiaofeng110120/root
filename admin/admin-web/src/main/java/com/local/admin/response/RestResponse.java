package com.local.admin.response;

import java.io.Serializable;

public class RestResponse<T> implements Serializable {

    private static final long serialVersionUID = 4893280118017319089L;

    private static final String SUCCESS_CODE = "000";

    private static final String SUCCESS_MESSAGE = "操作成功";

    private static final String ERROR_CODE = "999";

    private static final String ERROR_MESSAGE = "系统异常";

    private String code;

    private String msg;

    private T data;

    private RestResponse() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    private RestResponse(String code, String msg) {
        this(code, msg, (T) null);
    }

    private RestResponse(String code, String msg, T data) {
        this.code(code).msg(msg).result(data);
    }

    private RestResponse<T> code(String code) {
        this.setCode(code);
        return this;
    }

    private RestResponse<T> msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    private RestResponse<T> result(T data) {
        this.setData(data);
        return this;
    }

    private boolean success() {
        return SUCCESS_CODE.equals(this.code);
    }

    public boolean fail() {
        return !this.success();
    }

    public static <T> RestResponse<T> ok(T t) {
        return new RestResponse<>(SUCCESS_CODE, SUCCESS_MESSAGE, t);
    }

    public static <T> RestResponse<T> ok() {
        return new RestResponse<>();
    }

    public static <E> RestResponse<E> error(String code, String msg) {
        return new RestResponse<>(code, msg);
    }

    public static <T> RestResponse<T> error() {
        return new RestResponse<>(ERROR_CODE, ERROR_MESSAGE);
    }

    public static <T> RestResponse<T> error(String msg) {
        return new RestResponse<>(ERROR_CODE, msg);
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    private void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }


}
