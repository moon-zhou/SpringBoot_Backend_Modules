package org.moonzhou.backend.base.web.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.moonzhou.backend.base.common.annotations.MethodLog;
import org.moonzhou.backend.base.common.constants.LoggerEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description 注解打印日志aop处理类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/22
 */
@Aspect
@Component
public class AnnotationLogAspect {

    /**
     * 正常业务日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationLogAspect.class);

    /**
     * 注解日志logger
     */
    private static final Logger ANNOTATION_LOGGER = LoggerFactory.getLogger(LoggerEnum.ANNOTATION_LOGGER_NAME.getLogger());

    /**
     * 注解打印日志切入点
     */
    @Pointcut("@annotation(org.moonzhou.backend.base.common.annotations.MethodLog)")
    public void annotationLog() {
    }

    @Before("annotationLog()")
    public void before(JoinPoint joinPoint) {
        MethodLog methodLog = this.getAnnotationLog(joinPoint);
        ANNOTATION_LOGGER.info("打印: {}.{}.{} 开始前", methodLog.operationType(), methodLog.operationName(),
                methodLog.operationType());
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("annotationLog()")
    public void after(JoinPoint jp){
        ANNOTATION_LOGGER.info("方法最后执行");
    }

    /**
     * 处理完请求，返回内容
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "annotationLog()")
    public void doAfterReturning(Object ret) {
        ANNOTATION_LOGGER.info("方法的返回值 : {}", JSONObject.toJSONString(ret));
    }

    /**
     * 后置异常通知
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "annotationLog()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        ANNOTATION_LOGGER.error("方法异常时执行: ", e);
    }


    /**
     * 环绕增强，相当于MethodInterceptor
     */
    @Around("annotationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ANNOTATION_LOGGER.info("Around==========");

        Object res = null;
        long time = System.currentTimeMillis();
        try {
            res =  joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            ANNOTATION_LOGGER.info("res=========={}, time is: {}.", JSONObject.toJSONString(res), time);
        } catch (Throwable e) {
            LOGGER.error("AnnotationLogAspect 操作失败：", e);
        }
        return res;
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private MethodLog getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(MethodLog.class);
        }

        return null;
    }
}
