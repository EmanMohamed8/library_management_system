package org.example.library_management_system_data.repositories;

import org.example.library_management_system_data.models.Book;
import org.example.library_management_system_data.models.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    List<BorrowingRecord> findByBookId(Long book_id);
}
