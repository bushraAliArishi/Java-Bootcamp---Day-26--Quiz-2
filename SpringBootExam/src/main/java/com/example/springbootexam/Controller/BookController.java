package com.example.springbootexam.Controller;

import com.example.springbootexam.ApiResponse.ApiResponse;
import com.example.springbootexam.Model.Book;
import com.example.springbootexam.Model.User;
import com.example.springbootexam.Service.BookService;
import com.example.springbootexam.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private BookService bookService = new BookService();
    private UserService userService = new UserService();


    //CRUD
    @GetMapping("/display")
    public ResponseEntity getBookList() {

        return ResponseEntity.status(200).body(bookService.getBookList());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        bookService.setBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("book added"));
    }

    @PutMapping("/update/{ID}")
    public ResponseEntity updateBook(@PathVariable String ID, @RequestBody @Valid Book book, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean updated = bookService.updateBook(ID, book);
        if (updated) {
            return ResponseEntity.status(200).body(new ApiResponse("the book updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("the book is not found"));

    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity updateBook(@PathVariable String ID) {

        boolean deleted = bookService.deletBook(ID);
        if (deleted) {
            return ResponseEntity.status(200).body(new ApiResponse("the book deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("the book is not found"));

    }
    //CRUD


    //Create an endpoint that takes a Book name then returns one Book .
    //Create an endpoint that takes a category then return all books have this category.
    //Create an endpoint that takes a number of pages and returns all Books who have this number of pages or above .
    //Create an endpoint that change a book status to unavailable (Only the librarian can change the status of the book)
    @GetMapping("/Search/{name}")
    public ResponseEntity search(@PathVariable String name) {
        if (bookService.search(name) != null) {
            return ResponseEntity.status(200).body(new ApiResponse("the search result are " + bookService.search(name)));
        }
        return ResponseEntity.status(400).body(new ApiResponse("the book is not found"));
    }

    @GetMapping("/category/{cat}")
    public ResponseEntity category(@PathVariable String cat) {
        if (bookService.category(cat).size() > 0) {
            return ResponseEntity.status(200).body(new ApiResponse("the search result are " + bookService.category(cat)));
        }
        return ResponseEntity.status(400).body(new ApiResponse("there no book in this category"));
    }

    @GetMapping("/page/{number}")
    public ResponseEntity page(@PathVariable int number) {
        if (bookService.pagerange(number).size() > 0) {
            return ResponseEntity.status(200).body(new ApiResponse("the search result are " + bookService.pagerange(number)));
        }
        return ResponseEntity.status(400).body(new ApiResponse("there no book in this range"));
    }

    @PutMapping("/unavailable/{userID}/{bookID}")
    public ResponseEntity unavailableBook(@PathVariable String userID, @PathVariable String bookID) {
        boolean roll = userService.checkRoll(userID);
        if (roll) {
            boolean updated = bookService.bookStatus(bookID);
            if (updated) {
                ResponseEntity.status(200).body(new ApiResponse("the book now is unavailable"));
            }else
            {
                ResponseEntity.status(400).body(new ApiResponse("the book now not found"));
            }

        }
        return ResponseEntity.status(400).body(new ApiResponse("you  dont have accesses "));
    }
}
