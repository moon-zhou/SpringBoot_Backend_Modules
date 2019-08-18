package org.moonzhou.backend.base.service.dto.logger;

import com.alibaba.fastjson.JSON;
import org.moonzhou.backend.base.common.constants.SystemConstants;
import org.moonzhou.backend.base.common.utils.ValueMaskFilter;
import org.moonzhou.backend.base.service.dto.BaseDto;

/**
 * @Description 抽象统一日志格式，可以方便接入第三方日志分析系统（ELK）
 *              实际情况里，一般是第三方系统提供日志格式
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/18
 */
public class LoggerDto extends BaseDto {

    private static final long serialVersionUID = 521838136036776465L;

    /**
     * 抽象层
     */
    private String abstractLayer;

    /**
     * 系统简称
     */
    private String sysName = SystemConstants.SYSTEM_NAME;

    /**
     * 类＋方法
     */
    private String classMethod;

    /**
     * 运行时间
     */
    private Long runTime;

    /**
     * 入参和出参
     */
    private Object param;

    public String getAbstractLayer() {
        return abstractLayer;
    }

    public void setAbstractLayer(String abstractLayer) {
        this.abstractLayer = abstractLayer;
    }

    public String getSysName() {
        return sysName;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, ValueMaskFilter.getInstance());
    }
}
