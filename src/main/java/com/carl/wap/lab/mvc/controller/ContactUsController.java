package com.carl.wap.lab.mvc.controller;

import com.carl.wap.lab.mvc.model.CustomerMessage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "ContactUs", value = "/ContactUs")
public class ContactUsController extends HttpServlet {

    private int hitCount;

    private synchronized int incrHitCount() {
        return this.hitCount++;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        incrHitCount();
        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/contact-us.jsp");
        request.setAttribute("customerMessage", new CustomerMessage("","","",""));
        request.setAttribute("hitCount", hitCount);

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        incrHitCount();

        String fullName = request.getParameter("fullName").trim();
        String gender = request.getParameter("gender");
        String category = request.getParameter("category");
        String message = request.getParameter("message").trim();

        CustomerMessage customerMessage = new CustomerMessage(fullName, category,gender, message);
        String errorMessage = "";

        if (customerMessage.getName().equals("")) {
            errorMessage += "<div class=\"alert alert-danger\" role=\"alert\">Name is Missing</div>";
        }
        if (customerMessage.getGender() == null || customerMessage.getGender().equals("")) {
            errorMessage += "<div class=\"alert alert-danger\" role=\"alert\">Gender is Missing</div>";
        }
        if (customerMessage.getCategory() == null || customerMessage.getCategory().equals("")) {
            errorMessage += "<div class=\"alert alert-danger\" role=\"alert\">Category is Missing</div>";
        }
        if (customerMessage.getMessage().equals("")) {
            errorMessage += "<div class=\"alert alert-danger\" role=\"alert\">Message is Missing</div>";
        }

        request.setAttribute("hitCount", hitCount);

        if (!errorMessage.equals("")) {
            request.setAttribute("isErrMsgsPresent", true);
            request.setAttribute("errorMessages", errorMessage);
            request.setAttribute("customerMessage", customerMessage);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/contact-us.jsp");
            requestDispatcher.forward(request, response);
        } else {
            String currDateTime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy - h:mm:ss a zzzz"));
            request.setAttribute("currDateTime", currDateTime);
            request.setAttribute("customerMessage", customerMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/view/thankyou.jsp");
            dispatcher.forward(request, response);
        }
    }

}
