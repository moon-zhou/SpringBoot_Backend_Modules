package org.moonzhou.backend.base.service;

import org.moonzhou.backend.base.service.dto.book.BookDto;

import java.util.List;

/**
 * @Description 书籍业务逻辑处理类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/10/19
 */
public interface BookService {

    /**
     * 查询所有书籍
     * @return
     */
    List<BookDto> queryAllBook();

}
