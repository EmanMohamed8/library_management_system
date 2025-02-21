package org.example.library_management_system_data.dto;

import lombok.Data;
import org.example.library_management_system_data.models.Book;
import org.example.library_management_system_data.models.Patron;

import java.time.LocalDateTime;

@Data
public class BorrowingRecordDto {
    private Patron patron;
    private Book book;
    private LocalDateTime borrowingDate;
    private LocalDateTime returnDate;
}
