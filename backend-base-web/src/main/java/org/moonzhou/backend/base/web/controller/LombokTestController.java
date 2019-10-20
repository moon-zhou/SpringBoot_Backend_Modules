package org.moonzhou.backend.base.web.controller;

import org.moonzhou.backend.base.common.constants.SystemConstants;
import org.moonzhou.backend.base.service.BookService;
import org.moonzhou.backend.base.service.dto.book.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * lombok测试控制器
 *
 * @author moon-zhou
 * @Date: 2019/6/27 19:08
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/lombok/test")
public class LombokTestController extends BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(LombokTestController.class);

    @Autowired
    private BookService bookService;

    /**
     * 测试数据请求
     * http://localhost:8881/backend-base/lombok/test/test.do
     *
     * @return
     */
    @RequestMapping("/test" + SystemConstants.REQUEST_SUFFIX)
    @ResponseBody
    public List<BookDto> test() {
        return bookService.queryAllBook();
    }


}
