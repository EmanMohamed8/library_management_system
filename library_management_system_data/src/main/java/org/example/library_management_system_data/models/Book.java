package org.example.library_management_system_data.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book extends BaseEntity{
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publisher_year")
    private String publisher_year;
    @OneToMany
    @JoinColumn(name = "book_id")
    Set<BorrowingRecord> borrowingRecords = new HashSet<>();

    public Book(String title, String author, String isbn, String publisher, String publisher_year, Set<BorrowingRecord> borrowingRecords) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publisher_year = publisher_year;
        this.borrowingRecords = borrowingRecords;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher_year() {
        return publisher_year;
    }

    public void setPublisher_year(String publisher_year) {
        this.publisher_year = publisher_year;
    }

    public Set<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setBorrowingRecords(Set<BorrowingRecord> borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }
}
