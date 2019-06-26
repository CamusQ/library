package com.Camus.service.impl;

import com.Camus.repository.BookAdminRespository;
import com.Camus.repository.ReaderRepository;
import com.Camus.repository.impl.BookAdminRespositoryImpl;
import com.Camus.repository.impl.ReaderRepositoryImpl;
import com.Camus.service.AccountService;

/**
 * @auther camus
 * date 2019/6/26 16:46
 */
public class AccountServiceImpl implements AccountService {

    private ReaderRepository readerRepository = new ReaderRepositoryImpl();
    private BookAdminRespository bookAdminRespository = new BookAdminRespositoryImpl();

    @Override
    public Object login(String username, String password, String type) {
        Object obj = null;
        switch (type){
            case "reader":
                obj = readerRepository.login(username, password);
                break;
            case "bookadmin":
                obj = bookAdminRespository.login(username, password);
                break;
        }

        return obj;
    }
}
