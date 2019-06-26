package com.Camus.repository.impl;

import com.Camus.entity.BookAdmin;
import com.Camus.repository.BookAdminRespository;
import com.Camus.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @auther camus
 * date 2019/6/26 17:10
 */
public class BookAdminRespositoryImpl implements BookAdminRespository {
    QueryRunner queryRunner = new QueryRunner();

    @Override
    public BookAdmin login(String username, String password) {
        Connection conn = JDBCTools.getConnection();
        BookAdmin admin = null;
        String sql = "select * from bookadmin where username = ? and password = ?";
        try {
            admin = queryRunner.query(conn, sql, new BeanHandler<>(BookAdmin.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JDBCTools.release(conn, null, null);
        }
        return admin;
    }
}
