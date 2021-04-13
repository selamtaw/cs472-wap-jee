package com.example.lab_12;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContactUs", value = "/ContactUs")
public class ContactUs extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String category = request.getParameter("category");
        String message = request.getParameter("message");


        String name = fullName != null && !fullName.equals("")? fullName : "";
        String messageValue = message != null && !message.equals("")? message : "";

        // category data
        String isFeedbackEmpty = category != null && category.equals("feedback") ? "selected" : "";
        String isInquiryEmpty = category != null && category.equals("inquiry") ? "selected" : "";
        String isComplainEmpty = category != null &&  category.equals("complain") ? "selected" : "";

        //gender data
        String isMaleSelected = gender != null && gender.equals("male")? "checked": "";
        String isFemaleSelected = gender != null && gender.equals("female")? "checked": "";

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
        out.println("    <title>Hello, world!</title>");
        out.println("");
        out.println("</head>");
        out.println("<body>");
        out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">");
        out.println("    <a class=\"navbar-brand\" href=\"#\">CS472:::WAP</a>");
        out.println("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarTogglerDemo02\"");
        out.println("            aria-controls=\"navbarTogglerDemo02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
        out.println("        <span class=\"navbar-toggler-icon\"></span>");
        out.println("    </button>");
        out.println("");
        out.println("    <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo02\">");
        out.println("        <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">");
        out.println("            <li class=\"nav-item \">");
        out.println("                <a class=\"nav-link\" href=\"#\"> Home<span class=\"sr-only\">(current)</span></a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item\">");
        out.println("                <a class=\"nav-link\" href=\"#\">About</a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item active\">");
        out.println("                <a class=\"nav-link\" href=\"ContactUs\">Contact Us</a>");
        out.println("            </li>");
        out.println("        </ul>");
        out.println("        <form class=\"form-inline my-2 my-lg-0\">");
        out.println("            <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\">");
        out.println("            <button class=\"btn btn-outline-dark my-2 my-sm-0\" type=\"submit\">Search</button>");
        out.println("        </form>");
        out.println("    </div>");
        out.println("</nav>");
        out.println("<div class=\"jumbotron container\">");
        out.println("    <h1 class=\"display-6\">Customer Contact Form!</h1>");
        out.println("");

        /*add errors if there are any*/
        Object errorObject = request.getAttribute("errorMessages");
        if (errorObject != null) {
            String errorMessage = (String) errorObject;
            out.print(errorMessage);
        }
        out.println("    <form method=\"post\" action=\"ContactUsValidator\">");
        out.println("        <div class=\"form-group\">");
        out.println("            <label for=\"fullNameInput\">*Name</label>");

        out.println("            <input type=\"text\" class=\"form-control\" id=\"fullNameInput\" aria-describedby=\"fullName\"  name=\"fullName\" placeholder=\"e.g John Smith\" value=\"" + name + "\">");

        out.println("            <small id=\"fullName\" class=\"form-text text-muted\">Enter your full name.</small>");
        out.println("        </div>");
        out.println("");
        out.println("        <div>");
        out.println("            <label>*Gender</label><br>");
        out.println("");
        out.println("            <div class=\"form-check form-check-inline\">");
        out.println("                <input class=\"form-check-input\" type=\"radio\" name=\"gender\" id=\"maleSelectOption\"" + isMaleSelected);
        out.println("                       value=\"male\">");
        out.println("                <label class=\"form-check-label\" for=\"maleSelectOption\">Male</label>");
        out.println("            </div>");
        out.println("            <div class=\"form-check form-check-inline\">");
        out.println("                <input class=\"form-check-input\" type=\"radio\" name=\"gender\" id=\"femaleSelectOption\"" + isFemaleSelected);
        out.println("                       value=\"female\">");
        out.println("                <label class=\"form-check-label\" for=\"femaleSelectOption\">Female</label>");
        out.println("            </div>");
        out.println("        </div>");
        out.println("");
        out.println("        <div class=\"form-group\">");
        out.println("            <label for=\"categoryOption\">*Category</label>");
        out.println("");
        out.println("            <select class=\"form-control\" id=\"categoryOption\" name=\"category\">");
        out.println("                <option value=\"\">Select</option>");
        out.println("                <option value=\"feedback\" " +isFeedbackEmpty + ">Feedback</option>");
        out.println("                <option value=\"inquiry\" " + isInquiryEmpty+ ">Inquiry</option>");
        out.println("                <option value=\"complain\" " + isComplainEmpty + ">Complain</option>");
        out.println("            </select>");
        out.println("        </div>");
        out.println("        <div class=\"form-group\">");
        out.println("            <label for=\"messageTextArea\">*Message</label>");

        out.println("            <textarea class=\"form-control\" id=\"messageTextArea\" name=\"message\" rows=\"3\" > " + messageValue+" </textarea>");

        out.println("        </div>");
        out.println("");
        out.println("        <button type=\"submit\" class=\"btn btn-primary btn-block\">Submit</button>");
        out.println("    </form>");
        out.println("");
        out.println("");
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
        doGet(request, response);
    }
}
