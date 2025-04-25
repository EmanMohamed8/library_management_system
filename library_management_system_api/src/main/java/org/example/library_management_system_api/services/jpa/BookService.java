package org.example.library_management_system_api.services.jpa;

import jakarta.persistence.EntityNotFoundException;
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
//  read all books
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

//  read by book id
    @Override
    public Book getBookById(Long Id) {
        return bookRepository.findById(Id).orElse(null);
    }

//  save book
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

//  update book
    @Override
    public Book updateBook(Long bookId, Book book) {
//      check if book exists
        Book savedBook = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book Not Exists"));

//      update fields
        if(book.getAuthor() != null){
            savedBook.setAuthor(book.getAuthor());
        }
        if(book.getTitle() != null){
            savedBook.setTitle(book.getTitle());
        }
        if(book.getIsbn() != null){
            savedBook.setIsbn(book.getIsbn());
        }
        if(book.getPublisher() != null){
            savedBook.setPublisher(book.getPublisher());
        }

        return bookRepository.save(savedBook);
    }

    @Override
    public void deleteBookById(Long Id) {
        bookRepository.deleteById(Id);
    }

}
