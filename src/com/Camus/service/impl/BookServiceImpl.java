package com.Camus.service.impl;

import com.Camus.entity.Book;
import com.Camus.entity.BookCase;
import com.Camus.repository.BookCaseRepository;
import com.Camus.repository.BookRepository;
import com.Camus.repository.impl.BookCaseRepositoryImpl;
import com.Camus.repository.impl.BookRepositoryImpl;
import com.Camus.service.BookService;
import com.Camus.util.JDBCTools;

import java.sql.Connection;
import java.util.List;

/**
 * @auther camus
 * date 2019/6/26 20:12
 */
public class BookServiceImpl implements BookService {

    BookRepository bookRepository = new BookRepositoryImpl();
    BookCaseRepository bookCaseRepository = new BookCaseRepositoryImpl();

    @Override
    public List<Book> findAll(int page,int limit) {
        page = (page - 1) * limit;
        List<Book> bookList = bookRepository.findAll(page,limit);
        for (Book book : bookList) {
            int BookCaseId = book.getBookcaseid();
            BookCase bookCase = bookCaseRepository.find(BookCaseId);
            book.setBookCaseName(bookCase.getName());
        }
        return bookList;
    }

    @Override
    public int count() {
        return bookRepository.count();
    }

    @Override
    public void borrow(int bookId, int readerId, String borrowTime, String returnTime, int state) {
        bookRepository.borrow(bookId, readerId, borrowTime, returnTime, state);
        bookRepository.updateState(bookId,state);
    }

    @Override
    public void updateState(int id, int state) {
        bookRepository.updateState(id, state);
    }


}
