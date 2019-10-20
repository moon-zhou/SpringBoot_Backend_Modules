package org.moonzhou.backend.base.common.annotations;

import java.lang.annotation.*;

/**
 * 自定义日志注解
 * <code>@Target</code> 是注解的作用域 ：表示该注解可以用于一个类中的那些属性及方法上，如果作用域类型有多个用英文逗号分隔
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodLog {

    /**
     * 要执行的操作类型比如：add操作
     * @return
     */
    String operationType() default "";

    /**
     * 要执行的具体操作比如：添加用户
     * @return
     */
    String operationName() default "";

    /**
     * 其他描述信息
     * @return
     */
    String description() default "";
}