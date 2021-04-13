package com.example.lab_12;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ThankYou", value = "/ThankYou")
public class ThankYou extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String category = request.getParameter("category");
        String message = request.getParameter("message");

        out.println("<!doctype html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <!-- Required meta tags -->");
        out.println("    <meta charset=\"utf-8\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
        out.println("");
        out.println("    <!-- Bootstrap CSS -->");
        out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"");
        out.println("          integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        out.println("");
        out.println("    <title>Thank you!</title>");
        out.println("");
        out.println("</head>");
        out.println("<body>");
        out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">");
        out.println("  <a class=\"navbar-brand\" href=\"#\">CS472:::WAP</a>");
        out.println("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarTogglerDemo02\" aria-controls=\"navbarTogglerDemo02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
        out.println("    <span class=\"navbar-toggler-icon\"></span>");
        out.println("  </button>");
        out.println("");
        out.println("  <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo02\">");
        out.println("    <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">");
        out.println("      <li class=\"nav-item active\">");
        out.println("        <a class=\"nav-link\" href=\"#\"> Home<span class=\"sr-only\">(current)</span></a>");
        out.println("      </li>");
        out.println("      <li class=\"nav-item\">");
        out.println("        <a class=\"nav-link\" href=\"#\">About</a>");
        out.println("      </li>");
        out.println("      <li class=\"nav-item\">");
        out.println("        <a class=\"nav-link\" href=\"ContactUs\">Contact Us</a>");
        out.println("      </li>");
        out.println("    </ul>");
        out.println("    <form class=\"form-inline my-2 my-lg-0\">");
        out.println("      <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\">");
        out.println("      <button class=\"btn btn-outline-dark my-2 my-sm-0\" type=\"submit\">Search</button>");
        out.println("    </form>");
        out.println("  </div>");
        out.println("</nav>");
        out.println("");
        out.println("<div class=\"container\" >");
        out.println("");
        out.println("  <div class=\"card\">");
        out.println("    <div>");
        out.println("      <p style=\"float: right;padding: 2%;\">september, 26, 1994</p>");
        out.println("    </div>");
        out.println("");
        out.println("    <div class=\"alert alert-success\" role=\"alert\">");
        out.println("      <h3>Thank You! Your message has been received as follows:</h3>");
        out.println("    </div>");
        out.println("    <div class=\"card-body\">");
        out.println("      <h4 class=\"card-title\">Name: " + fullName +"</h4>");
        out.println("      <h4 class=\"card-subtitle mb-2 text-muted\">Gender: " + gender +"</h4>");
        out.println("      <h4 class=\"card-subtitle mb-2 text-muted\">Category: " + category +"</h4>");
        out.println("      <h4 class=\"card-text\">Message: " + message +"</h4>");
        out.println("");
        out.println("      <p>Please feel free to <a href=\"/ContactUs\">contact us</a> again</p>");
        out.println("    </div>");
        out.println("  </div>");
        out.println("</div>");
        out.println("");
        out.println("<!-- Optional JavaScript -->");
        out.println("<!-- jQuery first, then Popper.js, then Bootstrap JS -->");
        out.println("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"");
        out.println("        integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"");
        out.println("        crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"");
        out.println("        integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"");
        out.println("        crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"");
        out.println("        integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"");
        out.println("        crossorigin=\"anonymous\"></script>");
        out.println("</body>");
        out.println("</html>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
