package org.example.library_management_system_api.controllers;

import org.example.library_management_system_api.services.IBookService;
import org.example.library_management_system_data.dto.BookDto;
import org.example.library_management_system_data.models.Book;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final IBookService bookService;
    private final ModelMapper modelMapper;

    BookController(IBookService bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public List<BookDto> getBooks(){
        return bookService.getAllBooks()
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
    }

//    @GetMapping("")
//    public ResponseEntity<?> getAllBooks() {
//        return ResponseEntity.ok(bookService.getAllBooks());
//    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id){
        return modelMapper.map(bookService.getBookById(id), BookDto.class);
    }

    @PostMapping("")
    public BookDto addBook(@RequestBody BookDto bookDto) {
        Book savedBook =  bookService.addBook(modelMapper.map(bookDto, Book.class));
        return modelMapper.map(savedBook, BookDto.class);
    }


//    @PostMapping("")
//    public ResponseEntity<?> addBook(@RequestBody  BookDto bookDto) {
//        Book book = modelMapper.map(bookDto, Book.class);
//        return ResponseEntity.ok(bookService.addBook(book));
//    }


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return bookService.updateBook(modelMapper.map(bookDto, Book.class));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }

}
