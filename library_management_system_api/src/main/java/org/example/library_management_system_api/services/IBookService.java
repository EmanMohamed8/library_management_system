package org.example.library_management_system_api.services;

import org.example.library_management_system_data.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService extends ICRUDService<Book, Long>{
    List<Book> getAllBooks();
    Book getBookById(Long Id);
    Book addBook(Book book);
    Book updateBook(Long bookId, Book book);
    void deleteBookById(Long Id);
}
