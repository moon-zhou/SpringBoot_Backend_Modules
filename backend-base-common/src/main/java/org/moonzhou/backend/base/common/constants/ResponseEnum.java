package org.moonzhou.backend.base.common.constants;

/**
 * @Description 返回码枚举类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/12
 */
public enum ResponseEnum {
    SUCCESS("0000", "SUCCESS", "common success"),

    ;
    private String responseCode;

    private String responseMessage;

    private String responseDesc;

    ResponseEnum(String responseCode, String responseMessage, String responseDesc) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseDesc = responseDesc;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public String getResponseDesc() {
        return responseDesc;
    }
}
