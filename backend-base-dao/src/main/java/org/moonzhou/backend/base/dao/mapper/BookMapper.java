package org.moonzhou.backend.base.dao.mapper;

import org.moonzhou.backend.base.dao.dmo.Book;

import java.util.List;

public interface BookMapper {
    int insert(Book record);

    List<Book> selectAll();
}