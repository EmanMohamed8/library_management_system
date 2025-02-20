package org.example.library_management_system_data.dto;

import org.example.library_management_system_data.models.Book;
import org.example.library_management_system_data.models.Patron;

import java.time.LocalDateTime;

public class BorrowingRecordDto {
    private Patron patron;
    private Book book;
    private LocalDateTime borrowingDate;
    private LocalDateTime returnDate;

    public BorrowingRecordDto() {}

    public BorrowingRecordDto(Patron patron, Book book, LocalDateTime borrowingDate, LocalDateTime returnDate) {
        this.patron = patron;
        this.book = book;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
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
