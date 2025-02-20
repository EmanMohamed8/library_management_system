package org.example.library_management_system_data.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing_record")
public class BorrowingRecord extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "borrowing_date")
    private LocalDateTime borrowDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;

    public BorrowingRecord() {}

    public BorrowingRecord(Book book, Patron patron, LocalDateTime borrowDate, LocalDateTime returnDate) {
        this.book = book;
        this.patron = patron;
        this.borrowDate = borrowDate;
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

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
