package cn.estore.servlet;

import cn.estore.dao.ProductDao;
import cn.estore.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    public ProductServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获得一个输出流,用来响应客户端发出的请求
        PrintWriter out = response.getWriter();

        // 创建dao对象
        ProductDao dao = new ProductDao();

        // 获取是何种操作的参数action
        String action = request.getParameter("action");

        if (action.equals("selectAllProduct")) {// 查询所有商品
            String pageNum = request.getParameter("pageNum");

            List<ProductEntity> productList = dao.selectAllProducts();

            request.setAttribute("productList", productList);
            request.setAttribute("pageNum", pageNum);


            request.getRequestDispatcher("pages/product/main.jsp").forward(request, response);
        } else if (action.equals("showProductDiscount")) {
            List<ProductEntity> productList = dao.selectProductsDiscount(1);

            String pageNum = request.getParameter("pageNum");
            request.setAttribute("productList", productList);
            request.setAttribute("pageNum", pageNum);

            request.getRequestDispatcher("pages/product/showProductDiscount.jsp").forward(request, response);

        } else if (action.equals("showProductOriginal")) {
            List<ProductEntity> productList = dao.selectProductsDiscount(0);
            String pageNum = request.getParameter("pageNum");

            request.setAttribute("productList", productList);
            request.setAttribute("pageNum", pageNum);

            request.getRequestDispatcher("pages/product/showProductOriginal.jsp").forward(request, response);


        } else if (action.equals("selectProductByName")) {//按Name查找商品
            String name = request.getParameter("name");

            List<ProductEntity> productList = dao.selectProductsByName(name);
            String pageNum = request.getParameter("pageNum");

            request.setAttribute("productList", productList);
            request.setAttribute("name", name);
            request.setAttribute("pageNum", pageNum);
            request.getRequestDispatcher("pages/product/showFindProductByName.jsp").forward(request, response);
        }
    }


    public void init() throws ServletException {

    }

}
