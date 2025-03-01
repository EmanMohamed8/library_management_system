package org.example.library_management_system_api.services;

import jakarta.persistence.Id;
import org.example.library_management_system_api.services.ICRUDService;
import org.example.library_management_system_data.models.Patron;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatronService extends ICRUDService<Patron, Long> {
    public List<Patron> getPatrons();
    public Patron getPatronById(Long id);
    public Patron createPatron(Patron patron);
    public Patron updatePatron(Long id);
    public void deletePatron(Long id);
}
