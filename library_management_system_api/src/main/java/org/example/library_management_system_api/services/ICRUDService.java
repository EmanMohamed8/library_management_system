package org.example.library_management_system_api.services;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ICRUDService <T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T create(T t);
    void deleteById(ID id);
    void delete(T t);
}
