package com.carl.wap.lab.mvc.controller;

import com.carl.wap.lab.mvc.model.CustomerMessage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ThankYou", value = "/ThankYou")
public class ThankYou extends HttpServlet {
    private int hitCount;

    private synchronized int incrementHitCount() {
        return this.hitCount++;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        incrementHitCount();

        response.setContentType("text/html");

        CustomerMessage customerMessage = (CustomerMessage) request.getAttribute("customerMessage");

        request.setAttribute("customerMessage", customerMessage);
        request.setAttribute("hitCount", hitCount);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/view/thankyou.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
