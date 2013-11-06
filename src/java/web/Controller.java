/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CartBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpa.Merchandise;

/**
 *
 * @author HugoCésar
 */
@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

    @EJB
    CartBean cart;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (cart == null) {
            cart = new CartBean();
        }
        if ("list".equals(action)) {
            List<Merchandise> contents = cart.getContents();
            request.setAttribute("contents", contents);
        }

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String merchandise = request.getParameter("merchandise");
        String idp = request.getParameter("id");

        if (cart == null) {
            cart = new CartBean();
        }
        if ("add".equals(action)) {
            cart.add(merchandise);
        } else if ("delete".equals(action)) {
            cart.delete(Long.parseLong(merchandise));
        }
        else if ("update".equals(action)) {
            String sid = request.getParameter("idp");
            Long id = Long.valueOf(sid);
            cart.update(id,merchandise);
        }
        
        response.sendRedirect("index.jsp");
    }

}
