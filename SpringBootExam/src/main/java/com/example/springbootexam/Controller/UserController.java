package com.example.springbootexam.Controller;

import com.example.springbootexam.ApiResponse.ApiResponse;
import com.example.springbootexam.Model.User;
import com.example.springbootexam.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService=new UserService();
    //crud
    @GetMapping("/disply")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping("/add")
    public ResponseEntity adduser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));

    }
    @PutMapping("/update/{ID}")
    public ResponseEntity updateUser(@PathVariable String ID,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean updated=userService.updateUser(ID,user);
        if (updated){
            return ResponseEntity.status(200).body(new ApiResponse("user updated "));
        } return ResponseEntity.status(400).body(new ApiResponse("user not found "));

    }
    @DeleteMapping("/delete/{ID}")
    public ResponseEntity deleteUser (@PathVariable String ID){
        boolean deleted=userService.deleteUser(ID);
        if (deleted){
            return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
        }   return ResponseEntity.status(200).body(new ApiResponse("user not found"));

    }

    //crud


    //Create an endpoint that takes a  balance then returns all users have this balance or above .
    //Create an endpoint that takes an age then return all User who have this age  or above .
    @GetMapping("/getbalance/{balance}")
    public ResponseEntity getuserbalance(@PathVariable double balance){
        return ResponseEntity.status(200).body(userService.getBalance(balance));
    }
    @GetMapping("/age/{age}")
    public ResponseEntity getuserbalance(@PathVariable int age){
        return ResponseEntity.status(200).body(userService.getage(age));
    }








}

