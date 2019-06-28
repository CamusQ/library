package com.Camus.repository;

import com.Camus.entity.BookCase;

/**
 * @auther camus
 * date 2019/6/28 16:42
 */
public interface BookCaseRepository {
    public BookCase find(int id);
}
