package org.moonzhou.backend.base.web.controller;

import org.moonzhou.backend.base.common.annotations.MethodLog;
import org.moonzhou.backend.base.common.constants.SystemConstants;
import org.moonzhou.backend.base.common.utils.BeanUtil;
import org.moonzhou.backend.base.service.HelloService;
import org.moonzhou.backend.base.service.dto.BaseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @Date: 2019/6/27 19:08
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/hello")
public class HelloController extends BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    /**
     * 测试页面
     * http://localhost:8881/backend-base/hello/index.do
     *
     * @return
     */
    @Override
    @RequestMapping("/index" + SystemConstants.REQUEST_SUFFIX)
    public String init() {

        LOGGER.info("init index ftl page...11");

        return "/hello/index";
    }

    /**
     * 测试数据请求
     * http://localhost:8881/backend-base/hello/test.do
     *
     * @return
     */
    @RequestMapping("/test" + SystemConstants.REQUEST_SUFFIX)
    @ResponseBody
    public Map<String, Object> test() {

        return helloService.testQuery();
    }

    /**
     * 测试日志级别请求
     * http://localhost:8881/backend-base/hello/testLog.do
     *
     * @return
     */
    @RequestMapping("/testLog" + SystemConstants.REQUEST_SUFFIX)
    @ResponseBody
    public BaseDto testLog() {

        LOGGER.debug("debug level log content...");
        LOGGER.info("info level log content...");
        LOGGER.warn("warn level log content...");
        LOGGER.error("error level log content...");

        BaseDto baseDto = new BaseDto();

        return baseDto;
    }

    /**
     * 测试注解日志请求
     * controller上直接使用MethodLog是始终都会生效的
     * http://localhost:8881/backend-base/hello/testAnnotationLog.do
     *
     * @return
     */
    @MethodLog(operationType = "testType", operationName = "testUser", description = "测试注解日志")
    @RequestMapping("/testAnnotationLog" + SystemConstants.REQUEST_SUFFIX)
    @ResponseBody
    public BaseDto testAnnotationLog() {

        // 这个使用的是spring上下文里的对象去调用initReturn方法，所以initReturn方法上的methodLog注解会被AnnotationLogAspect的规则拦截
        return BeanUtil.getBean(this.getClass()).initReturn();

        // 此处调用方法，已经被拦截处理过，即被动态代理拦截了，再直接调用别的方法，是通过代理对象调用的，方法是不会被增强的，即initReturn方法上注解不会生效
        // return initReturn();
    }

    /**
     * 测试注解日志打印
     *
     * @return
     */
    @MethodLog(operationType = "init", operationName = "testUser", description = "初始化controller返回值")
    public BaseDto initReturn() {
        return new BaseDto();
    }

}
