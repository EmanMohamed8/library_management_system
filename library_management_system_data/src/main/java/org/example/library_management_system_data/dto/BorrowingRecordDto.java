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
}
