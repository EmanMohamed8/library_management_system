package org.example.library_management_system_api.services;

import org.example.library_management_system_data.models.BorrowingRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface IBorrowingService extends ICRUDService<BorrowingRecord, Long> {
    List<BorrowingRecord> getAllBorrowingRecord();
    BorrowingRecord createBorrowingRecord(Long bookId, Long PatronId, BorrowingRecord borrowingRecord);
    BorrowingRecord updateBorrowingRecord(Long bookId, Long PatronId, BorrowingRecord borrowingRecord);
}
