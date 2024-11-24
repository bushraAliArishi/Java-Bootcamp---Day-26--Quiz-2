package com.example.springbootexam.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    //ID , name , number_of_pages , price  , category  , isAvailable
   @NotEmpty(message = "the book ID cant be empty")
   @Size(min = 4,message = "the Id length cant be less than 4 ")
    private String ID;
    @NotEmpty(message = "the book name cant be empty")
    @Size(min = 7,message = "the name cant be less than 3 character")
    private String name;
    @NotNull(message = "the number of pages cant be empty")
    @Positive(message = "the page number must be a positive number")
    private int numberOfPages;
    @NotNull(message = "the price mustn't be empty")
    @PositiveOrZero(message = "the price must be zero or positive number")
    private double price;
    @NotEmpty(message = "the category cant be empty")
    @Pattern(regexp = "^(novel|academic)+$",message = "the category must be a novel or academic")
    private String category;
    @NotNull(message = "the availability cant be empty ")
    @Pattern(regexp = "^(available|unavailable)+$",message = "must be a available or unavailable")

    private String isAvailable;
}
