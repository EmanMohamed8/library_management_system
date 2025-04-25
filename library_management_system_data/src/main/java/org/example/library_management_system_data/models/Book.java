package org.example.library_management_system_data.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book extends BaseEntity{
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publisher_year")
    private String publisherYear;
    @Column(name = "isbn")
    private String isbn;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<BorrowingRecord> borrowingRecords = new HashSet<>();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublisherYear() {
        return publisherYear;
    }

    public Set<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setBorrowingRecords(Set<BorrowingRecord> borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }

    public void setPublisherYear(String publisher_year) {
        this.publisherYear = publisher_year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
