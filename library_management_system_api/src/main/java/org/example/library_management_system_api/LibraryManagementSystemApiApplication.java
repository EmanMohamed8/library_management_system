package org.example.library_management_system_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.example.library_management_system_api", "org.example.library_management_system_data"})

//@EnableJpaRepositories("library_management_system_data.src.main.java.org.example.library_management_system_data.repositories")
//@EntityScan(basePackages = "org.example.library_management_system_data.models")
@EnableJpaRepositories(basePackages = "org.example.library_management_system_data.repositories")
@EntityScan(basePackages = "org.example.library_management_system_data.models")

public class LibraryManagementSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApiApplication.class, args);
    }

}
