package org.example.library_management_system_api.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.library_management_system_api.services.IBookService;
import org.example.library_management_system_api.services.jpa.BookService;
import org.example.library_management_system_data.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final IBookService bookService;

    BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(Long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/")
    public Book addBook(Book book){
        return bookService.addBook(book);
    }

    @PutMapping("{id}")
    public Book updateBook(Long id){
        return bookService.updateBook(id);
    }

    @DeleteMapping("{id}")
    public void deleteBook(Long id){
        bookService.deleteBookById(id);
    }

}
