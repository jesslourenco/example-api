package com.example.api.application.usecase;

import com.example.api.domain.Foo;

import java.util.List;

public interface FooUseCases {
    public List<Foo> findAll();
    public Foo find(Long id);
    public Foo save(Foo foo);
    public boolean exists(Long id);
    public Foo update(Foo update);
    public Foo partialUpdate(Foo update);
    public void delete(Long id);
}
