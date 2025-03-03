package org.example.library_management_system_data.dto;

import lombok.*;

import java.io.Serializable;

@Data
public class BookDto implements Serializable {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
