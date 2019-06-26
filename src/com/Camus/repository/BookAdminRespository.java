package com.Camus.repository;

import com.Camus.entity.BookAdmin;

/**
 * @auther camus
 * date 2019/6/26 17:09
 */
public interface BookAdminRespository {
    public BookAdmin login(String username,String password);
}
