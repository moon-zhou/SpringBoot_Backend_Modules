package org.moonzhou.backend.base.service.dto;

import org.moonzhou.backend.base.common.constants.ResponseEnum;

/**
 * @Description 对外返回的dto对象基类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/3
 */
public class BaseDto {

    // 默认成功
    private String responseCode = ResponseEnum.SUCCESS.getResponseCode();

    private String responseMessage;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public boolean isSuccess() {
        return responseCode != null && responseCode.equals(ResponseEnum.SUCCESS.getResponseCode());
    }
}
