package org.example.library_management_system_data.models;

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
    private LocalDateTime borrowDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
}
