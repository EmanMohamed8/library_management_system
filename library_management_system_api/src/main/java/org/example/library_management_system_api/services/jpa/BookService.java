package org.example.library_management_system_api.services.jpa;

import jakarta.persistence.Id;
import org.example.library_management_system_api.services.IBookService;
import org.example.library_management_system_data.models.Book;
import org.example.library_management_system_data.models.Patron;
import org.example.library_management_system_data.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;


@Service
public class BookService extends CRUDService<Book, Long> implements IBookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        super(bookRepository);
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long Id) {
        return bookRepository.findById(Id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long Id) {
        Book book = getBookById(Id);
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long Id) {
        bookRepository.deleteById(Id);
    }

}
