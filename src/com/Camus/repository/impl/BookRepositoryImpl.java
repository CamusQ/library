package com.Camus.repository.impl;

import com.Camus.entity.Book;
import com.Camus.repository.BookRepository;
import com.Camus.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @auther camus
 * date 2019/6/26 20:18
 */
public class BookRepositoryImpl implements BookRepository {

    QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Book> findAll() {
        Connection conn = JDBCTools.getConnection();
        List<Book> bookList = null;
        String sql = "select * from book";
        try {
             bookList = queryRunner.query(conn, sql, new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(conn, null, null);
        }
        return bookList;

    }
}
