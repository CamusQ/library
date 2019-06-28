package com.Camus.repository.impl;

import com.Camus.entity.BookCase;
import com.Camus.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @auther camus
 * date 2019/6/28 16:43
 */
public class BookCaseRepositoryImpl implements com.Camus.repository.BookCaseRepository {

    QueryRunner queryRunner = new QueryRunner();

    @Override
    public BookCase find(int id) {
        Connection conn = JDBCTools.getConnection();
        BookCase bookCase = null;
        String sql = "select * from bookcase where id = ?";
        try {
            bookCase = queryRunner.query(conn, sql, new BeanHandler<>(BookCase.class),id);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(conn, null, null);
        }
        return bookCase;
    }
}
