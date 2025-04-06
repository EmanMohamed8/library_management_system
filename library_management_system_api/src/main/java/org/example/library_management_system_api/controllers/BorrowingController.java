package org.example.library_management_system_api.controllers;

import jakarta.transaction.Transactional;
import org.example.library_management_system_api.services.IBorrowingService;
import org.example.library_management_system_data.dto.BorrowingRecordDto;
import org.example.library_management_system_data.models.BorrowingRecord;
import org.example.library_management_system_data.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/borrow/{book_id}/patron/{patron_id}")
public class BorrowingController {
    IBorrowingService borrowingService;
    ModelMapper modelMapper;
    BorrowingController(IBorrowingService borrowingService, ModelMapper modelMapper){
        this.borrowingService = borrowingService;
        this.modelMapper = modelMapper;
    }
//we need transactional here we can't borrow a book already borrowed

    @PostMapping("")
    BorrowingRecordDto createBorrow(@PathVariable Long book_id, @PathVariable Long patron_id) {

//        BorrowingRecord savedBorrowingRecord;
//        savedBorrowingRecord.setBook(BookRepository.);
//        borrowingService.createBorrowingRecord(book_id, patron_id);
//        return modelMapper.map(savedBorrowingRecord, BorrowingRecordDto.class);
    }
//    @PutMapping("")
//    BorrowingRecordDto updateBorrow(@PathVariable Long book_id, @PathVariable Long patron_id){
//        BorrowingRecord savedBorrowingRecord = borrowingService.updateBorrowingRecord(modelMapper.map(borrowingRecordDto, BorrowingRecord.class));
//        return modelMapper.map(savedBorrowingRecord, BorrowingRecordDto.class);
//    }
}

