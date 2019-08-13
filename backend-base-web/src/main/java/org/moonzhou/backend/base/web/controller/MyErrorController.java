package org.moonzhou.backend.base.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/13
 */
@Controller
public class MyErrorController {

    private static Logger LOGGER = LoggerFactory.getLogger(MyErrorController.class);

    private static final String PATH = "/error.do";

    /**
     * 异常的分别处理--------------------------------》》》》》》》》》》》》
     *
     * @param request
     * @return
     */
    @RequestMapping(value = PATH)
    public String handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        LOGGER.info("error code is {}.", statusCode);

        switch (statusCode) {
            case 404:
                return "error/404";
            case 500:
                return "error/500";
            default:
                return "index";
        }
    }
}
