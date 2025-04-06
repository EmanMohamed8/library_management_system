package org.example.library_management_system_api.services;

import org.example.library_management_system_data.models.BorrowingRecord;
import org.springframework.stereotype.Service;

@Service
public interface IBorrowingService extends ICRUDService<BorrowingRecord, Long> {
    BorrowingRecord createBorrowingRecord(BorrowingRecord borrowingRecord);
    BorrowingRecord updateBorrowingRecord(BorrowingRecord borrowingRecord);
}
