package org.example.library_management_system_api.services.jpa;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import org.example.library_management_system_api.services.IPatronService;
import org.example.library_management_system_data.models.Patron;
import org.example.library_management_system_data.repositories.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService extends CRUDService<Patron, Long> implements IPatronService {
    private final PatronRepository patronRepository;

    PatronService(PatronRepository patronRepository) {
        super(patronRepository);
        this.patronRepository = patronRepository;
    }

//  read all patrons
    @Override
    public List<Patron> getPatrons() {
        return patronRepository.findAll();
    }

//  read patron by id
    @Override
    public Patron getPatronById(Long id) {
        return patronRepository.findById(id).orElse(null);
    }

//  save new patron
    @Override
    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }

//  update patron
    @Override
    public Patron updatePatron(Long id, Patron patron) {
//      check if patron exists
        Patron savedPatron = patronRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patron Not Exists"));

//      update fields
        if(patron.getPhoneNumber() != null){
            savedPatron.setPhoneNumber(patron.getPhoneNumber());
        }
        if(patron.getEmail() != null){
            savedPatron.setEmail(patron.getEmail());
        }
        if (patron.getFirstName() != null){
            savedPatron.setFirstName(patron.getFirstName());
        }
        if (patron.getLastName() != null){
            savedPatron.setLastName(patron.getLastName());
        }

        return patronRepository.save(savedPatron);
    }

    @Override
    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
