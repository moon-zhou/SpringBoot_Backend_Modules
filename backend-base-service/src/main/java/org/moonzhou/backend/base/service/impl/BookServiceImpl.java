package org.moonzhou.backend.base.service.impl;

import org.moonzhou.backend.base.dao.dmo.Book;
import org.moonzhou.backend.base.dao.mapper.BookMapper;
import org.moonzhou.backend.base.service.BookService;
import org.moonzhou.backend.base.service.dto.book.BookDto;
import org.moonzhou.backend.base.utils.impl.BookConvert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/10/19
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<BookDto> queryAllBook() {
        List<Book> bookList = bookMapper.selectAll();

        List<BookDto> bookDtoList = new ArrayList<BookDto>();

        BookConvert bookConvert = new BookConvert();
        bookList.forEach(book -> {
            BookDto bookDto = bookConvert.convert(book);

            bookDtoList.add(bookDto);
        });

        return bookDtoList;
    }
}
