package cn.estore.servlet;

import cn.estore.dao.CustomerDao;
import cn.estore.entity.CustomerEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", urlPatterns = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取是何种操作的参数action
        String action = request.getParameter("action");

        if ("checkUsername".equals(action)) {
            this.checkUserName(request, response);
        }


    }

    public void checkUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得一个输出流,用来响应客户端发出的请求
        PrintWriter out = response.getWriter();

        // 创建dao对象
        CustomerDao dao = new CustomerDao();

        String username = request.getParameter("username");

        CustomerEntity user = dao.selectCustomerEntity(username);
        if (user != null) {
            out.print("用户名已存在!");
        } else {
            out.print("用户名可用!");
        }
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
