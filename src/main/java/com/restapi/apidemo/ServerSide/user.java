package com.restapi.apidemo.ServerSide;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class user {


@NotBlank(message = "Name can not be empty")
@Size(min = 3, max = 12, message = "Username must be 3 -12 character")
    private String userName;

    @Email(message = "Invalid Email !!")
    @NotBlank(message = "email can not be empty")
    private String Email;
    @Min(value = 18, message = "Age mus t be greater than 18")
    private int age;


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    

    
}
