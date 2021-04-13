package com.example.lab_12;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContactUsValidator", value = "/ContactUsValidator")
public class ContactUsValidator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/ContactUs");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String category = request.getParameter("category");
        String message = request.getParameter("message");

        String errorMessage = "";

        if (fullName.equals("")) {
            errorMessage += "<div class=\"alert alert-danger\" role=\"alert\">Name is Missing</div>";
        }
        if (gender == null) {
            errorMessage += "<div class=\"alert alert-danger\" role=\"alert\">Gender is Missing</div>";
        }
        if (category.equals("")) {
            errorMessage += "<div class=\"alert alert-danger\" role=\"alert\">Category is Missing</div>";
        }
        if (message.equals("")) {
            errorMessage += "<div class=\"alert alert-danger\" role=\"alert\">Message is Missing</div>";
        }

        if (!errorMessage.equals("")) {
            request.setAttribute("errorMessages", errorMessage);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ContactUs");
            requestDispatcher.forward(request, response);
        } else {
            String redirectUrl = "ThankYou?fullName=" + fullName + "&gender=" + gender + "&category=" + category + "&message=" + message;
            response.sendRedirect(redirectUrl);
        }
    }
}
