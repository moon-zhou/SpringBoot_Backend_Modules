package org.moonzhou.backend.base.web.controller;

import org.moonzhou.backend.base.service.HelloService;
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

    /*@RequestMapping("/index.do")
    public String init() {

        LOGGER.info("init index ftl page...");

        return "/hello/index";
    }*/

    @RequestMapping("/test.do")
    @ResponseBody
    public Map<String, Object> test() {

        return helloService.testQuery();
    }

}
