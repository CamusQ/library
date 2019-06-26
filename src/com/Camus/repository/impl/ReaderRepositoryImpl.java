package com.Camus.repository.impl;

import com.Camus.entity.Reader;
import com.Camus.repository.ReaderRepository;
import com.Camus.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @auther camus
 * date 2019/6/26 16:58
 */
public class ReaderRepositoryImpl implements ReaderRepository {

    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public Reader login(String username, String password) {
        Connection conn = JDBCTools.getConnection();
        String sql = "select * from reader where username = ? and password = ? ";
        Reader reader = null;
        try {
            reader = queryRunner.query(conn, sql, new BeanHandler<>(Reader.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(conn, null, null);
        }
        return reader;
    }
}
