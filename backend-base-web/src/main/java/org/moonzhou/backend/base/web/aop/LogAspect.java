package org.moonzhou.backend.base.web.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
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

        Object res = null;
        long time = System.currentTimeMillis();
        try {
            // 方法执行前，打印入参
            printParams(CONTROLLER_LOGGER, joinPoint);

            // 执行方法
            res = joinPoint.proceed();

            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            try {
                // 方法执行完成后增加日志
                addOperationLog(CONTROLLER_LOGGER, LoggerEnum.CONTROLLER_APPENDER_NAME.getAbstractLayer(), joinPoint, res, time);
            } catch (Exception e) {
                // 分层日志异常，记录到业务日志中
                LOGGER.error("记录日志异常： ", e);
            }
        }
    }

    /**
     * 环绕增强，相当于MethodInterceptor
     * 环绕service
     */
    @Around("serviceLog()")
    public Object aroundService(ProceedingJoinPoint joinPoint) throws Throwable {

        Object res = null;
        long time = System.currentTimeMillis();
        try {
            // 方法执行前，打印入参
            printParams(SERVICE_LOGGER, joinPoint);

            // 执行方法
            res = joinPoint.proceed();

            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            try {
                // 方法执行完成后增加日志
                addOperationLog(SERVICE_LOGGER, LoggerEnum.CONTROLLER_APPENDER_NAME.getAbstractLayer(), joinPoint, res, time);
            } catch (Exception e) {
                // 分层日志异常，记录到业务日志中
                LOGGER.error("记录日志异常： ", e);
            }
        }
    }

    /**
     * 环绕增强，相当于MethodInterceptor
     * 环绕dao
     */
    @Around("daoLog()")
    public Object aroundDao(ProceedingJoinPoint joinPoint) throws Throwable {

        Object res = null;
        long time = System.currentTimeMillis();
        try {
            // 方法执行前，打印入参
            printParams(DAO_LOGGER, joinPoint);

            // 执行方法
            res = joinPoint.proceed();

            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            try {
                // 方法执行完成后增加日志
                addOperationLog(DAO_LOGGER, LoggerEnum.CONTROLLER_APPENDER_NAME.getAbstractLayer(), joinPoint, res, time);
            } catch (Exception e) {
                // 分层日志异常，记录到业务日志中
                LOGGER.error("记录日志异常： ", e);
            }
        }
    }

    /**
     * 打印入参数据
     * @param point
     */
    private void printParams(Logger logger, ProceedingJoinPoint point) {

        // 获取参数值
        Object[] args = point.getArgs();

        // 通过这获取到方法的所有参数名称的字符串数组
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();

        JSONObject params = new JSONObject();

        if (null != parameterNames && parameterNames.length > 0) {
            for (int i = 0; i < parameterNames.length; i++) {

                Object arg = args[i];

                // 只输出参数是String类型的
                /*if (arg instanceof String) {
                    params.put(parameterNames[i], arg);
                }*/

                try {
                    params.put(parameterNames[i], arg);
                } catch (Exception e) {
                    LOGGER.info("param to json object error.");
                    LOGGER.error("param to json object exception:", e);
                }

            }
        }

        // 输出请求的参数
        try {
            logger.info("{} request param is: {}", getMethod(point), JSON.toJSONString(params, ValueMaskFilter.getInstance()));
        } catch (Exception e) {
            LOGGER.info("monitor print error.");
            LOGGER.error("stack info is:", e);
        }
    }

    /**
     * 具体打印日志方法
     */
    private void addOperationLog(Logger logger, String abstractLayer, ProceedingJoinPoint joinPoint, Object res, long time) {
        // 实例化日志对象
        LoggerDto loggerDto = new LoggerDto();
        loggerDto.setAbstractLayer(abstractLayer);
        loggerDto.setClassMethod(getMethod(joinPoint));
        loggerDto.setRunTime(time);
        loggerDto.setParam(res);

        logger.info("layer log: {}", loggerDto);
    }

    /**
     * 按照 类名+"."+方法名获取调用方法名称
     *
     * @param point
     * @return
     */
    private String getMethod(ProceedingJoinPoint point) {
        StringBuilder method = new StringBuilder();

        MethodSignature signature = (MethodSignature) point.getSignature();
        method.append(signature.getDeclaringType().getSimpleName()).append(".")
                .append(signature.getName());

        return method.toString();
    }
}
