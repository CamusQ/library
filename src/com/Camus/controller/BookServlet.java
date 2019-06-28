package com.Camus.controller;

import com.Camus.entity.Book;
import com.Camus.entity.BookVO;
import com.Camus.service.BookService;
import com.Camus.service.impl.BookServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther camus
 * date 2019/6/26 20:09
 */
public class BookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");//解决乱码问题
        List<Book> bookList = bookService.findAll();
        BookVO bookVO = new BookVO();
        bookVO.setCode(0);
        bookVO.setMsg("");
        bookVO.setCount(100);
        bookVO.setData(bookList);
        JSONObject jsonObject = JSONObject.fromObject(bookVO);
        resp.getWriter().write(jsonObject.toString());
    }
}
