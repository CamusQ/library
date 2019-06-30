package com.Camus.repository;

import com.Camus.entity.Book;

import java.util.List;

/**
 * @auther camus
 * date 2019/6/26 20:13
 */
public interface BookRepository {
    public List<Book> findAll(int page,int limit);
    public int count();
    public void borrow(int bookId,int readerId,String borrowTime,String returnTime,int state);
    public void updateState(int id,int state);

}
