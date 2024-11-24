package com.example.springbootexam.Service;

import com.example.springbootexam.Model.Book;
import com.example.springbootexam.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class BookService {
    final private ArrayList<Book> books = new ArrayList<>();
    public UserService userService=new UserService();
    //CRUD
    public ArrayList<Book> getBookList() {
        return books;
    }

    public void setBook(Book book) {
        books.add(book);
    }

    public boolean updateBook(String ID, Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID().equals(ID)) {
                books.set(i, book);
                return true;
            }

        }
        return false;
    }

    public boolean deletBook(String ID) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID().equals(ID)) {
                books.remove(books.get(i));
                return true;
            }

        }
        return false;
    }

    //CRUD
    public Book search(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {

                return books.get(i);
            }

        }
        return null;
    }
    public ArrayList<Book> category(String category) {
       ArrayList<Book>catBook=new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCategory().equals(category)) {
                catBook.add(books.get(i));

            }

        }
        return catBook;
    }
    public ArrayList<Book> pagerange(int number) {
       ArrayList<Book>pageBook=new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getNumberOfPages()<=number) {
                pageBook.add(books.get(i));

            }

        }
        return pageBook;
    }
    public boolean bookStatus(String bookID){

            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getID().equalsIgnoreCase(bookID)) {
                    books.get(i).setIsAvailable("unavailable");
                    return true;
                }
            }
        return false;
    }


}

