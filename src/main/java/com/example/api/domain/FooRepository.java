package com.example.api.domain;

import java.util.List;
import java.util.Optional;

public interface FooRepository {
    List<Foo> findAll();
    Optional<Foo> findById(Long id);
    Foo save(Foo foo);
    boolean existsById(Long id);
    void deleteById(Long id);
}
