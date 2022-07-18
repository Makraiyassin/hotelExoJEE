package com.bxl.javatym.hotel.servlet.customer;

import com.bxl.javatym.hotel.models.Customer;
import com.bxl.javatym.hotel.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteCustomer", value = "/customer/delete")
public class ServletDeleteCustomer extends HttpServlet {

    private final CustomerService service = CustomerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/customer/add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;

        try{
            id = Integer.parseInt(request.getParameter("customer_id"));
            service.delete(id);
        }
        catch(NumberFormatException ex){
            response.sendError(400, "ID invalide");
        }


        response.sendRedirect(request.getContextPath() + "/");
    }
}