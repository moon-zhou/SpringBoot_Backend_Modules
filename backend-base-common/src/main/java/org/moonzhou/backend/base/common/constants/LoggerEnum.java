package org.moonzhou.backend.base.common.constants;

/**
 * @Description logback里自定义分层日志appender name
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/18
 */
public enum LoggerEnum {
    CONTROLLER_APPENDER_NAME("ControllerLogger", "controllerLog","controller层logback日志appender"),
    SERVICE_APPENDER_NAME("ServiceLogger", "serviceLog","service层logback日志appender"),
    DAO_APPENDER_NAME("DaoLogger", "daoLog","dao层logback日志appender"),

    ;

    /**
     * logback里对应的logger
     */
    private String logger;

    /**
     * 日志对象里的分层字段值
     */
    private String abstractLayer;

    /**
     * 含义描述
     */
    private String desc;

    LoggerEnum(String logger, String abstractLayer, String desc) {
        this.logger = logger;
        this.abstractLayer = abstractLayer;
        this.desc = desc;
    }

    public String getLogger() {
        return logger;
    }

    public String getAbstractLayer() {
        return abstractLayer;
    }

    public String getDesc() {
        return desc;
    }
}
