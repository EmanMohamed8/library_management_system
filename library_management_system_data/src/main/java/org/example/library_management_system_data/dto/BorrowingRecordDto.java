package org.example.library_management_system_data.dto;

import lombok.Data;
import org.example.library_management_system_data.models.Book;
import org.example.library_management_system_data.models.Patron;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BorrowingRecordDto implements Serializable {
    private Long id;
    private Patron patron;
    private Book book;
    private LocalDateTime borrowingDate;
    private LocalDateTime returnDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDateTime borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
