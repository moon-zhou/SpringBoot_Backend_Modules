package org.moonzhou.backend.base.service.dto;

import com.alibaba.fastjson.annotation.JSONField;
import org.moonzhou.backend.base.common.constants.ResponseEnum;

import java.io.Serializable;

/**
 * @Description 对外返回的dto对象基类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/3
 */
public class BaseDto implements Serializable {

    private static final long serialVersionUID = -5641821170472070951L;

    // 默认成功
    private String responseCode = ResponseEnum.SUCCESS.getResponseCode();

    private String responseMessage;

    /**
     * 每页显示条数，默认 10
     */
    @JSONField(serialize=false)
    private long size = 10;

    /**
     * 当前页
     */
    @JSONField(serialize=false)
    private long current = 1;

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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public boolean isSuccess() {
        return responseCode != null && responseCode.equals(ResponseEnum.SUCCESS.getResponseCode());
    }
}
