package com.Camus.service;

import com.Camus.entity.Book;

import java.util.List;

/**
 * @auther camus
 * date 2019/6/26 20:12
 */
public interface BookService {
    public List<Book> findAll(int page,int limit);
    public int count();
    public void borrow(int bookId,int readerId,String borrowTime,String returnTime,int state);
    public void updateState(int id, int state);
}
