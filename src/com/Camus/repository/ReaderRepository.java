package com.Camus.repository;

import com.Camus.entity.Reader;

/**
 * @auther camus
 * date 2019/6/26 16:57
 */
public interface ReaderRepository {
    public Reader login(String username,String password);
}
