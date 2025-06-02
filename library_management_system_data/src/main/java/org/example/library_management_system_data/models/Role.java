package org.example.library_management_system_data.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    String name;

    public Role(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
