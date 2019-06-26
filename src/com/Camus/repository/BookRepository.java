package com.Camus.repository;

import com.Camus.entity.Book;

import java.util.List;

/**
 * @auther camus
 * date 2019/6/26 20:13
 */
public interface BookRepository {
    public List<Book> findAll();
}
