package com.Camus.repository.impl;

import com.Camus.entity.Book;
import com.Camus.repository.BookRepository;
import com.Camus.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @auther camus
 * date 2019/6/26 20:18
 */
public class BookRepositoryImpl implements BookRepository {

    QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Book> findAll(int start,int limit) {
        Connection conn = JDBCTools.getConnection();
        List<Book> bookList = null;
        String sql = "select * from book where abled = 1 limit ?,?";

        try {
            bookList = queryRunner.query(conn, sql, new BeanListHandler<>(Book.class),start,limit);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(conn, null, null);
        }
        return bookList;

    }

    @Override
    public int count() {
        Connection conn = JDBCTools.getConnection();
        int size = 0;
        String sql = "select count(id) from book";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                size = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(conn, ps, rs);
        }

        return size;
    }

    @Override
    public void borrow(int bookId, int readerId, String borrowTime, String returnTime, int state) {
        Connection conn = JDBCTools.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into borrow(bookid,readerid,borrowtime,returntime,state) values(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,bookId);
            ps.setInt(2, readerId);
            ps.setString(3, borrowTime);
            ps.setString(4, returnTime);
            ps.setInt(5, state);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(conn, ps, null);
        }

    }

    @Override
    public void updateState(int id, int state) {
        Connection conn = JDBCTools.getConnection();
        String sql = "update book set abled = ? where id = ?";
        try {
            queryRunner.update(conn, sql, state, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(conn, null, null);
        }
    }
}
