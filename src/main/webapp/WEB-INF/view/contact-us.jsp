<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Contact Us</title>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">CS472:::WAP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="#"> Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="ContactUs">Contact Us</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search">
            <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="jumbotron container">
    <h1 class="display-6">Customer Contact Form!</h1>

    <c:if test="${isErrMsgsPresent}">
        <div>
                ${errorMessages}
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/ContactUs" method="post">
        <div class="form-group">
            <label for="fullNameInput">*Name</label>
            <input type="text" class="form-control" id="fullNameInput" aria-describedby="fullName"
                   placeholder="e.g John Smith" name="fullName" value="${customerMessage.name}">
            <small id="fullName" class="form-text text-muted">Enter your full name.</small>
        </div>

        <div>
            <label>*Gender</label><br>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="maleSelectOption"
                       value="male" ${customerMessage.gender.equals("male") ? "checked" : ""}>
                <label class="form-check-label" for="maleSelectOption">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender"  id="femaleSelectOption"
                       value="female" ${customerMessage.gender.equals("female") ? "checked" : ""}>
                <label class="form-check-label" for="femaleSelectOption">Female</label>
            </div>
        </div>

        <div class="form-group">
            <label for="categoryOption">*Category</label>
            <select class="form-control" id="categoryOption" name="category">
                <option value="">Select</option>
                <option value="feedback" ${customerMessage.category.equals("feedback")? "selected" : ""}>Feedback</option>
                <option value="inquiry" ${customerMessage.category.equals("inquiry")? "selected" : ""}>Inquiry</option>
                <option value="complain" ${customerMessage.category.equals("complain")? "selected" : ""}>Complain</option>
            </select>
        </div>
        <div class="form-group">
            <label for="messageTextArea">*Message</label>
            <textarea class="form-control" id="messageTextArea" rows="3"
                      name="message">${customerMessage.message}</textarea>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Submit</button>
    </form>


    <div style="padding: 2%;">

        <span style="float: left;">Hit Count cor this page: ${(hitCount != null) ? hitCount : "--"}</span>
        <span style="float: right;">Total Hit Count for the entire WebApp: ${(totalHitCount != null) ? totalHitCount : "--"} </span>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
</body>
</html>