package com.Camus.service.impl;

import com.Camus.entity.Borrow;
import com.Camus.repository.ReaderRepository;
import com.Camus.repository.impl.ReaderRepositoryImpl;
import com.Camus.service.ReaderService;

import java.util.List;

/**
 * @auther camus
 * date 2019/6/29 16:13
 */
public class ReaderServiceImpl implements ReaderService {
    ReaderRepository readerRepository = new ReaderRepositoryImpl();

    @Override
    public List<Borrow> findBorrowById(int id) {
        return readerRepository.findBorrowById(id);
    }
}
