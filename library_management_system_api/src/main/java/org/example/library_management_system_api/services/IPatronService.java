package org.example.library_management_system_api.services;

import jakarta.persistence.Id;
import org.example.library_management_system_api.services.ICRUDService;
import org.example.library_management_system_data.models.Patron;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatronService extends ICRUDService<Patron, Long> {
    List<Patron> getPatrons();
    Patron getPatronById(Long id);
    Patron createPatron(Patron patron);
    Patron updatePatron(Long id, Patron patron);
    void deletePatron(Long id);
}
