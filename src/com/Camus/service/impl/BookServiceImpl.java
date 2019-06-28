package com.Camus.service.impl;

import com.Camus.entity.Book;
import com.Camus.entity.BookCase;
import com.Camus.repository.BookCaseRepository;
import com.Camus.repository.BookRepository;
import com.Camus.repository.impl.BookCaseRepositoryImpl;
import com.Camus.repository.impl.BookRepositoryImpl;
import com.Camus.service.BookService;

import java.util.List;

/**
 * @auther camus
 * date 2019/6/26 20:12
 */
public class BookServiceImpl implements BookService {

    BookRepository bookRepository = new BookRepositoryImpl();
    BookCaseRepository bookCaseRepository = new BookCaseRepositoryImpl();

    @Override
    public List<Book> findAll() {
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            int BookCaseId = book.getBookcaseid();
            BookCase bookCase = bookCaseRepository.find(BookCaseId);
            book.setBookCaseName(bookCase.getName());
        }
        return bookList;
    }
}
