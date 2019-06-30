package com.Camus.controller;

import com.Camus.entity.Borrow;
import com.Camus.entity.Reader;
import com.Camus.service.ReaderService;
import com.Camus.service.impl.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @auther camus
 * date 2019/6/29 10:52
 */
public class ReaderServlet extends HttpServlet {

    ReaderService readerService = new ReaderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method != null){
            switch (method){
                case "getBorrow":
                    HttpSession session = req.getSession();
                    Reader reader = (Reader) session.getAttribute("reader");
                    int readerId = reader.getId();
                    List<Borrow> borrowList = readerService.findBorrowById(readerId);
                    System.out.println(borrowList);
                    break;
            }
        }
    }
}
