package com.carl.wap.lab.mvc.controller;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Java Servlet 4.0";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("message", "This is a message from the Controller/Servlet :)");
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/view/hello-servlet.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}