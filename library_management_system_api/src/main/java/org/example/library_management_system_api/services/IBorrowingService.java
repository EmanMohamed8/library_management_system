package org.example.library_management_system_api.services;

import org.example.library_management_system_data.models.BorrowingRecord;

public interface IBorrowingService extends ICRUDService<BorrowingRecord, Long> {
    public BorrowingRecord createBorrowingRecord(BorrowingRecord borrowingRecord);
    public BorrowingRecord updateBorrowingRecord(BorrowingRecord borrowingRecord);
}
