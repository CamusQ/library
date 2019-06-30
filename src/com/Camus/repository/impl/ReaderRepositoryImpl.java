package com.Camus.repository.impl;

import com.Camus.entity.Borrow;
import com.Camus.entity.Reader;
import com.Camus.repository.ReaderRepository;
import com.Camus.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public List<Borrow> findBorrowById(int id) {
        Connection conn = JDBCTools.getConnection();
        List<Borrow> list = null;
        String sql =  "select b.name as bookName,b.author,b.price,r.cardid,r.name as readerName,r.tel,\n" +
                "br.borrowtime,br.returntime,br.state\n" +
                "from borrow br , book b, reader r\n" +
                "where br.readerid = r.id and br.bookid = b.id and br.readerid = ?";
        try {
            list = queryRunner.query(conn, sql, new BeanListHandler<>(Borrow.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(conn, null, null);
        }
        return list;
    }
}
