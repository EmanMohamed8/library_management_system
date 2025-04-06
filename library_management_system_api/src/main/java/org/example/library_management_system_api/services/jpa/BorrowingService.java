package org.example.library_management_system_api.services.jpa;

import org.example.library_management_system_api.services.IBorrowingService;
import org.example.library_management_system_data.models.BorrowingRecord;
import org.example.library_management_system_data.repositories.BookRepository;
import org.example.library_management_system_data.repositories.BorrowingRecordRepository;
import org.example.library_management_system_data.repositories.PatronRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class BorrowingService extends CRUDService<BorrowingRecord, Long> implements IBorrowingService {
    BorrowingRecordRepository borrowingRecordRepository;

    public BorrowingService(BorrowingRecordRepository borrowingRecordRepository) {
        super(borrowingRecordRepository);
        this.borrowingRecordRepository = borrowingRecordRepository;
    }

    @Override
    public BorrowingRecord createBorrowingRecord(BorrowingRecord borrowingRecord) {
        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Override
    public BorrowingRecord updateBorrowingRecord(BorrowingRecord borrowingRecord) {
        return borrowingRecordRepository.save(borrowingRecord);
    }
}
