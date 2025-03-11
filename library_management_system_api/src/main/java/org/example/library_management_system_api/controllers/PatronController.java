package org.example.library_management_system_api.controllers;

import org.example.library_management_system_api.services.IPatronService;
import org.example.library_management_system_data.dto.PatronDto;
import org.example.library_management_system_data.models.Patron;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/patrons")
class PatronController{
    IPatronService patronService;
    ModelMapper modelMapper;

    PatronController(IPatronService patronService, ModelMapper modelMapper) {
        this.patronService = patronService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    List<PatronDto> getPatrons(){
        List<Patron> patrons = patronService.getPatrons();
        return patrons
                .stream()
                .map(patron -> modelMapper.map(patron, PatronDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    PatronDto getPatronById(@PathVariable Long id){
        Patron patron = patronService.getPatronById(id);
        return modelMapper.map(patron, PatronDto.class);
    }

    @PostMapping("")
    PatronDto createPatron(@RequestBody PatronDto patronDto){
        Patron savedPatron = patronService.createPatron(modelMapper.map(patronDto, Patron.class));
        return modelMapper.map(savedPatron, PatronDto.class);
    }

    @PutMapping("/{id}")
    PatronDto updatePatron(@PathVariable Long id, @RequestBody PatronDto patronDto){
        Patron patron = modelMapper.map(patronDto, Patron.class);
        patronService.updatePatron(id, patron);
        return patronDto;
    }

    @DeleteMapping("/{id}")
    void deletePatronById(@PathVariable Long id){
        patronService.deletePatron(id);
    }

}
