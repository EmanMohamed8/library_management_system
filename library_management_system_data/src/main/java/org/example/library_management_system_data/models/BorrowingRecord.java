package org.example.library_management_system_data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private LocalDateTime borrowingDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;

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

    public void setBorrowingDate(LocalDateTime borrowDate) {
        this.borrowingDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
