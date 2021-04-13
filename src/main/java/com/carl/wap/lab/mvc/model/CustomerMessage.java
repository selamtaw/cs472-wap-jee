package com.carl.wap.lab.mvc.model;

public class CustomerMessage {
    private String name;
    private String category;
    private String gender;
    private String message;

    public CustomerMessage(String name, String category, String gender, String message){
        setName(name);
        setCategory(category);
        setGender(gender);
        setMessage(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
