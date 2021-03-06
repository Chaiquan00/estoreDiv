package cn.estore.servlet;

import cn.estore.dao.CustomerDao;
import cn.estore.entity.CustomerEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CustomerServlet", urlPatterns = "/CustomerServlet")

public class CustomerServlet extends HttpServlet {

    CustomerDao dao = new CustomerDao();

    public CustomerServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

//    public void init() throws ServletException {
//    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        CustomerDao dao = new CustomerDao();

        String action = request.getParameter("action");

        switch (action) {
            case "userLogin":
                this.login(request, response);
                break;
            case "logout":
                session.invalidate();
                request.getRequestDispatcher("/ProductServlet?action=selectAllProduct&pageNum=0").forward(request, response);
                break;
            case "userRegister":
                this.userRegister(request, response);
                break;
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String name = request.getParameter("username");
        CustomerEntity userEntity = dao.selectCustomerEntity(name);

        if (userEntity == null) {
            request.setAttribute("msg", "?????????????????????????????????????????????");
        } else {
            if (!request.getParameter("password").trim().equals(userEntity.getPassword())) {
                request.setAttribute("msg", "????????????,????????????????????????");
            } else {
                session.setAttribute("user", userEntity);
                session.setAttribute("name", name);
                request.setAttribute("msg", "???????????????");
            }
        }
        request.getRequestDispatcher("/ProductServlet?action=selectAllProduct&pageNum=0").forward(request, response);
    }

    public void userRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        //??????????????????
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String passwordQuestion = request.getParameter("passwordQuestion");
        String passwordHintAnswer = request.getParameter("passwordHintAnswer");
        //?????????????????????
        CustomerEntity user = new CustomerEntity();

        if (dao.selectCustomerEntity(username) == null) {//???????????????????????????
            // ????????????
            user.setUserName(username);
            user.setPassword(password);
            user.setRealName(realName);
            user.setMobile(mobile);
            user.setEmail(email);
            user.setPasswordQuestion(passwordQuestion);
            user.setPasswordHintAnswer(passwordHintAnswer);
            //??????????????????
            boolean flag = dao.insertCustomer(user);

            if (flag) {
                session.setAttribute("user", user);
                request.setAttribute("msg", "???????????????");
                request.getRequestDispatcher("/ProductServlet?action=selectAllProduct&pageNum=0").forward(request, response);
            } else {
                request.setAttribute("msg", "???????????????");
                request.getRequestDispatcher("/ProductServlet?action=selectAllProduct&pageNum=0").forward(request, response);
            }

        } else {
            request.setAttribute("msg", "???????????????????????????");
            request.getRequestDispatcher("/ProductServlet?action=selectAllProduct&pageNum=0").forward(request, response);
        }
    }

}
