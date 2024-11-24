package com.example.springbootexam.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    //    ID , name , age ,  balance , role
    @NotEmpty(message = "the user ID cant be empty ")
    @Size(min = 4, message = "the user ID cant be less than 4")
    private String ID;
    @NotEmpty(message = "the user name cant be empty")
    @Size(min = 5, message = "the name length cant be less than 5")
    private String name;
    @NotNull(message = "the user age cant be empty")
    @Positive(message = "the user age cant be zero or negative number ")
    @Min(value = 18, message = "the user age cant be less than 18")
    private int age;
    @Positive(message = "the user balance cant be zero or less")
    @NotNull(message = "the user balance cant be empty")
    private double balance;
    @NotEmpty(message = "the user roll cant be empty ")
    @Pattern(regexp = "^(customer|libraian)+$")
    private String roll;

}
