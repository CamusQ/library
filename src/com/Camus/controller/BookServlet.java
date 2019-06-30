package com.Camus.controller;

import com.Camus.entity.Book;
import com.Camus.entity.BookVO;
import com.Camus.entity.Reader;
import com.Camus.service.BookService;
import com.Camus.service.impl.BookServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        String method = req.getParameter("method");
        if(method == null){
            method = "findAll";
        }
        switch (method){
            case "findAll":
                resp.setContentType("text/json;charset=utf-8");//解决乱码问题
                String pageStr = req.getParameter("page");
                String limitStr = req.getParameter("limit");
                int page = Integer.parseInt(pageStr);
                int limit = Integer.parseInt(limitStr);
                List<Book> bookList = bookService.findAll(page,limit);
                BookVO bookVO = new BookVO();
                bookVO.setCode(0);
                bookVO.setMsg("");
                bookVO.setCount(bookService.count());
                bookVO.setData(bookList);
                JSONObject jsonObject = JSONObject.fromObject(bookVO);
                resp.getWriter().write(jsonObject.toString());
                break;
            case "borrow":
                String bookStr = req.getParameter("bookid");
                int bookID = Integer.parseInt(bookStr);
                HttpSession session = req.getSession();
                Reader reader =(Reader) session.getAttribute("reader");
                int readerId = reader.getId();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String borrorTime = simpleDateFormat.format(new Date());
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 14);
                    String returnTime = simpleDateFormat.format(calendar.getTime());
                    bookService.borrow(bookID, readerId, borrorTime, returnTime, 0);
                break;
        }

    }
}
