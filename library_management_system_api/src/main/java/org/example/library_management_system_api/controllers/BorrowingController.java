package org.example.library_management_system_api.controllers;

import jakarta.transaction.Transactional;
import org.example.library_management_system_api.services.IBorrowingService;
import org.example.library_management_system_data.dto.BookDto;
import org.example.library_management_system_data.dto.BorrowingRecordDto;
import org.example.library_management_system_data.dto.PatronDto;
import org.example.library_management_system_data.models.BorrowingRecord;
import org.example.library_management_system_data.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/borrow")
public class BorrowingController {
    IBorrowingService borrowingService;
    ModelMapper modelMapper;
    BorrowingController(IBorrowingService borrowingService, ModelMapper modelMapper){
        this.borrowingService = borrowingService;
        this.modelMapper = modelMapper;
    }

    public BorrowingRecordDto toDto(BorrowingRecord borrowingRecord){
        BorrowingRecordDto dto = modelMapper.map(borrowingRecord, BorrowingRecordDto.class);
        dto.setBookDto(modelMapper.map(borrowingRecord.getBook(), BookDto.class));
        dto.setPatronDto(modelMapper.map(borrowingRecord.getPatron(), PatronDto.class));
        return dto;
    }

    @GetMapping("")
    Set<BorrowingRecordDto> fetchBorrowingRecord(){
        Set<BorrowingRecordDto> borrowingRecordDtos  = borrowingService.getAllBorrowingRecord().stream().map(record -> toDto(record)).collect(Collectors.toSet());
        return borrowingRecordDtos;
    }

    @Transactional
    @PostMapping("/{book_id}/patron/{patron_id}")
    BorrowingRecordDto createBorrowingRecord(
            @PathVariable Long book_id,
            @PathVariable Long patron_id,
            @RequestBody BorrowingRecordDto borrowingRecordDto) {
       BorrowingRecord borrowingRecord =  borrowingService.createBorrowingRecord(book_id, patron_id, modelMapper.map(borrowingRecordDto, BorrowingRecord.class));
       return toDto(borrowingRecord);
    }

    @PutMapping("/{book_id}/patron/{patron_id}")
    BorrowingRecordDto updateBorrowRecord(
            @PathVariable Long book_id,
            @PathVariable Long patron_id,
            @RequestBody BorrowingRecordDto borrowingRecordDto) {
        BorrowingRecord borrowingRecord = borrowingService.updateBorrowingRecord(book_id, patron_id, modelMapper.map(borrowingRecordDto, BorrowingRecord.class));
        return toDto(borrowingRecord);
    }
}

