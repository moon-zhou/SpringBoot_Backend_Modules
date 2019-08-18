package org.moonzhou.backend.base.web.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.moonzhou.backend.base.common.constants.LoggerEnum;
import org.moonzhou.backend.base.common.utils.ValueMaskFilter;
import org.moonzhou.backend.base.service.dto.logger.LoggerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description 分层打印日志aop类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/18
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 正常业务日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    /**
     * controller日志打印对象
     */
    private static final Logger CONTROLLER_LOGGER = LoggerFactory.getLogger(LoggerEnum.CONTROLLER_APPENDER_NAME.getLogger());

    /**
     * service日志打印对象
     */
    private static final Logger SERVICE_LOGGER = LoggerFactory.getLogger(LoggerEnum.SERVICE_APPENDER_NAME.getLogger());

    /**
     * dao日志打印对象
     */
    private static final Logger DAO_LOGGER = LoggerFactory.getLogger(LoggerEnum.DAO_APPENDER_NAME.getLogger());

    /**
     * 切入点描述 这个是controller包的切入点
     */
    @Pointcut("execution(public * org.moonzhou.backend.base.web.controller..*.*(..))")
    public void controllerLog() {
    }//签名，可以理解成这个切入点的一个名称

    @Pointcut("execution(public * org.moonzhou.backend.base.service.impl..*.*(..))")
    public void serviceLog() {
    }

    @Pointcut("execution(public * org.moonzhou.backend.base.dao.mapper..*.*(..))")
    public void daoLog() {
    }

    /**
     * 环绕增强，相当于MethodInterceptor
     * 环绕controller
     */
    @Around("controllerLog()")
    public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {

        // TODO 1. 方法执行前，打印入参
        Object res = null;
        long time = System.currentTimeMillis();
        try {
            // 执行方法
            res = joinPoint.proceed();

            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            try {
                // TODO 2. 方法执行完成后增加日志
                addOperationLog(CONTROLLER_LOGGER, LoggerEnum.CONTROLLER_APPENDER_NAME.getAbstractLayer(), joinPoint, res, time);
            } catch (Exception e) {
                // 分层日志异常，记录到业务日志中
                LOGGER.error("记录日志异常： ", e);
            }
        }
    }

    // TODO 3. 具体打印日志方法
    private void addOperationLog(Logger logger, String abstractLayer, JoinPoint joinPoint, Object res, long time) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();

        // 实例化日志对象
        LoggerDto loggerDto = new LoggerDto();
        loggerDto.setAbstractLayer(abstractLayer);
        loggerDto.setClassMethod(signature.getDeclaringTypeName() + "." + signature.getName());
        loggerDto.setRunTime(time);
        loggerDto.setParam(JSON.toJSONString(res, ValueMaskFilter.getInstance()));

        logger.info("layer log: {}", loggerDto);
    }
}
