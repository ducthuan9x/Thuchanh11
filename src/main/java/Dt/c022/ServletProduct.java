package Dt.c022;

import Model.Product;
import Sevice.ProductSevice;
import Sevice.ProductSeviceHtlm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProduct", urlPatterns = "/Products")
public class ServletProduct extends HttpServlet {
    ProductSeviceHtlm ps=new ProductSeviceHtlm();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
    if(action==null){
        action="";
    }
    switch (action){
        case "create" :
            showCreate(request,response);
            break;
        case "edit":
            showEdit(request,response);
            break;
        case "delete":
            showDelete(request,response);
            break;

        default:
            showListPage(request,response);
    }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("Product/delete.jsp");
        int id= Integer.parseInt(request.getParameter("id"));
        Product product=ps.findById(id);
        request.setAttribute("spCanXoa",product);
        rd.forward(request,response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("Product/edit.jsp");
        int id= Integer.parseInt(request.getParameter("id"));
        Product product=ps.findById(id);
        request.setAttribute("spCanSua",product);
        rd.forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("Product/create.jsp");
        rd.forward(request,response);

    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("Product/listNew.jsp");
        List<Product> productList= ps.display();
        request.setAttribute("danhSach",productList);
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create" :
                createProduct(request,response);
                break;
            case "edit" :
                editProduct(request,response);
                break;
            case "delete" :
                deleteProduct(request,response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        ps.delete(id);
        response.sendRedirect("/Products");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        int price= Integer.parseInt(request.getParameter("price"));
        String name=request.getParameter("name");
        ps.edit(id,new Product(id,name,price));
        response.sendRedirect("/Products");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        int price= Integer.parseInt(request.getParameter("price"));
        String name=request.getParameter("name");
        ps.save(new Product(id,name,price));
        response.sendRedirect("/Products");
    }
}
