package com.local.util.error;

public enum BaseErrorCodeEnum {
    ;



    /**
     * 错误代码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    BaseErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据错误代码获取错误信息
     *
     * @param code 错误代码
     * @return msg 错误信息
     */
    public static String getMsgByCode(String code) {
        BaseErrorCodeEnum[] values = BaseErrorCodeEnum.values();
        for (BaseErrorCodeEnum errorCode : values) {
            if (errorCode.getCode().equals(code)) {
                return errorCode.getMsg();
            }
        }
        return "";
    }

    /**
     * 根据错误代码获取错误枚举
     *
     * @param code 错误代码
     * @return ErrorCode 错误枚举
     */
    public static BaseErrorCodeEnum getErrorCodeByCode(String code) {
        BaseErrorCodeEnum[] values = BaseErrorCodeEnum.values();
        for (BaseErrorCodeEnum errorCode : values) {
            if (errorCode.getCode().equals(code)) {
                return errorCode;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
