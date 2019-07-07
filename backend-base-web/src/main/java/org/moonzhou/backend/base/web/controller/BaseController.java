package org.moonzhou.backend.base.web.controller;

import org.moonzhou.backend.base.common.constants.SystemConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping("/index" + SystemConstants.REQUEST_SUFFIX)
    public String init() {

        LOGGER.info("load project index page in template..");

        return "/index";
    }
}
