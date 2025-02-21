package org.example.library_management_system_data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
