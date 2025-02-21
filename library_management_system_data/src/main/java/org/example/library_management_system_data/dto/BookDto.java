package org.example.library_management_system_data.dto;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
