package org.example.library_management_system_data.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PatronDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
