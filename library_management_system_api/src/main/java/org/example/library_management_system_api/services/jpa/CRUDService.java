package org.example.library_management_system_api.services.jpa;

import org.example.library_management_system_api.services.ICRUDService;
import org.example.library_management_system_data.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public abstract class CRUDService<T, ID> implements ICRUDService<T, ID> {
    JpaRepository<T, ID> repository;

    public CRUDService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T create(T object) {
        return repository.save(object);
    }

    @Override
    public void deleteById(ID id){
        repository.deleteById(id);
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }
}
