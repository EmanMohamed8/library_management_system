package org.example.library_management_system_data.repositories;

import org.example.library_management_system_data.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(Long id);

    @Override
    void deleteById(Long id);
}
