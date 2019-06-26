package com.Camus.service.impl;

import com.Camus.entity.Book;
import com.Camus.repository.BookRepository;
import com.Camus.repository.impl.BookRepositoryImpl;
import com.Camus.service.BookService;

import java.util.List;

/**
 * @auther camus
 * date 2019/6/26 20:12
 */
public class BookServiceImpl implements BookService {

    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
