package org.example.library_management_system_api.services.jpa;

import jakarta.persistence.Id;
import org.example.library_management_system_api.services.IPatronService;
import org.example.library_management_system_data.models.Patron;
import org.example.library_management_system_data.repositories.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService extends CRUDService<Patron, Long> implements IPatronService {
    private final PatronRepository patronRepository;

    PatronService(PatronRepository patronRepository) {
        super(patronRepository);
        this.patronRepository = patronRepository;
    }

    @Override
    public List<Patron> getPatrons() {
        return patronRepository.findAll();
    }

    @Override
    public Patron getPatronById(Long id) {
        return patronRepository.findById(id).orElse(null);
    }

    @Override
    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Override
    public Patron updatePatron(Long id) {
        Patron patron = patronRepository.findById(id).orElse(null);
        assert patron != null;
        return patronRepository.save(patron);
    }

    @Override
    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
