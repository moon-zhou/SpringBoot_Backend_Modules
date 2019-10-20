package org.moonzhou.backend.base.utils.impl;

import org.moonzhou.backend.base.dao.dmo.Book;
import org.moonzhou.backend.base.service.dto.book.BookDto;
import org.moonzhou.backend.base.utils.DTOConvert;
import org.springframework.beans.BeanUtils;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/10/19
 */
public class BookConvert implements DTOConvert<Book, BookDto> {
    @Override
    public BookDto convert(Book book) {
        BookDto bookDto = new BookDto();

        BeanUtils.copyProperties(book, bookDto);

        return bookDto;
    }
}
