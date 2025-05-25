package org.example.library_management_system_api.services.jpa;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.library_management_system_api.services.IBorrowingService;
import org.example.library_management_system_data.models.Book;
import org.example.library_management_system_data.models.BorrowingRecord;
import org.example.library_management_system_data.models.Patron;
import org.example.library_management_system_data.repositories.BookRepository;
import org.example.library_management_system_data.repositories.BorrowingRecordRepository;
import org.example.library_management_system_data.repositories.PatronRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class BorrowingService extends CRUDService<BorrowingRecord, Long> implements IBorrowingService {
    BorrowingRecordRepository borrowingRecordRepository;
    BookRepository bookRepository;
    PatronRepository patronRepository;

    public BorrowingService(BorrowingRecordRepository borrowingRecordRepository, BookRepository bookRepository, PatronRepository patronRepository) {
        super(borrowingRecordRepository);
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    @Override
    public List<BorrowingRecord> getAllBorrowingRecord() {
        List<BorrowingRecord> borrowingRecords = borrowingRecordRepository.findAll();
        return borrowingRecords;
    }

    @Transactional
    @Override
    public BorrowingRecord createBorrowingRecord(Long bookId, Long PatronId, BorrowingRecord borrowingRecord) {
//      check if the book exists
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book Not Exist"));

//      check if the patron exists
        Patron patron = patronRepository.findById(PatronId)
                .orElseThrow(() -> new EntityNotFoundException("Patron Not Exist"));

//     Check if the book is currently borrowed and not yet returned
        borrowingRecordRepository.findByBookId(bookId).forEach(exsistingBorrowingRecord -> {
            if(exsistingBorrowingRecord.getBorrowingDate() == null || exsistingBorrowingRecord.getReturnDate().isAfter(LocalDateTime.now())){
                throw new IllegalStateException("Book currently borrowed!");
            }
        });

//      save the borrowing record
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Transactional
    @Override
    public BorrowingRecord updateBorrowingRecord(Long bookId, Long PatronId, BorrowingRecord borrowingRecord) {
        if(borrowingRecord.getId() == null){
            throw new IllegalStateException("Borrowing Record  record ID must not be null for update.");
        }
//      check if borrowing record exists
        BorrowingRecord savedBorrowingRecord = borrowingRecordRepository.findById(borrowingRecord.getId())
                .orElseThrow(() -> new EntityNotFoundException("Borrowing Record Not Exist"));

//      check if the book exists
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book Not Exist"));

//      check if the patron exists
        Patron patron = patronRepository.findById(PatronId)
                .orElseThrow(() -> new EntityNotFoundException("Patron Not Exist"));

        savedBorrowingRecord.setBook(book);
        savedBorrowingRecord.setPatron(patron);
        savedBorrowingRecord.setReturnDate(borrowingRecord.getReturnDate());
        savedBorrowingRecord.setBorrowingDate(borrowingRecord.getBorrowingDate());
        return borrowingRecordRepository.save(savedBorrowingRecord);
    }
}
