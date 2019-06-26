package com.Camus.controller;

import com.Camus.entity.BookAdmin;
import com.Camus.entity.Reader;
import com.Camus.service.AccountService;
import com.Camus.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @auther camus
 * date 2019/6/26 16:25
 */
public class AccountServlet extends HttpServlet {

    AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method != null){
            switch (method){
                case "login":
                    String username = req.getParameter("username");
                    String password = req.getParameter("password");
                    String type = req.getParameter("type");
                    Object obj = accountService.login(username, password, type);
                    if(obj == null){
                        resp.sendRedirect("login.jsp");
                    }else{
                        switch (type){
                            case "reader":
                                Reader reader = (Reader)obj;
                                HttpSession session = req.getSession();
                                session.setAttribute("reader", reader);
                                resp.sendRedirect("index.jsp");
                                break;
                            case "bookadmin":
                                BookAdmin bookAdmin = (BookAdmin)obj;
                                System.out.println(bookAdmin);
                                break;
                        }
                    }
                    break;
                case "logout":
                    HttpSession session = req.getSession();
                    session.invalidate();
                    resp.sendRedirect("login.jsp");
                    break;
            }
        }

    }
}
