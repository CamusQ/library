package com.Camus.service;

import com.Camus.entity.Borrow;

import java.util.List;

/**
 * @auther camus
 * date 2019/6/29 15:47
 */
public interface ReaderService {
    public List<Borrow> findBorrowById(int id);

}
