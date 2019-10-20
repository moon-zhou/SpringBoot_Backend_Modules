package org.moonzhou.backend.base.service.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/10/19
 */
public class PageDto extends BaseDto {
    /**
     * 每页显示条数，默认 10
     */
    @JSONField(serialize = false)
    private long size = 10;

    /**
     * 当前页
     */
    @JSONField(serialize = false)
    private long current = 1;

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
}
