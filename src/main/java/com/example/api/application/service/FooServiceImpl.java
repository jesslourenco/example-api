package com.example.api.application.service;

import com.example.api.application.port.inbound.FooUseCases;
import com.example.api.domain.Foo;
import com.example.api.domain.FooRepository;
import com.example.api.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.function.BiConsumer;

@Service
@AllArgsConstructor
public class FooServiceImpl implements FooUseCases {

    private final FooRepository fooRepository;

    private final Converter converter;

    public List<Foo> findAll() {
        return fooRepository.findAll();
    }

    public Foo find(Long id) {
        return fooRepository.findById(id).orElseThrow(NoResultException::new);
    }

    public Foo save(Foo foo) {
        return fooRepository.save(foo);
    }

    public boolean exists(Long id) {
        return fooRepository.existsById(id);
    }

    @Transactional
    public Foo update(Foo update) {
        return update(update, converter::map);
    }

    @Transactional
    public Foo partialUpdate(Foo update) {
        return update(update, converter::mapWithoutNull);
    }


    private Foo update(Foo update, BiConsumer<Foo,Foo> consumer) {

        Foo foo = find(update.getId());

        consumer.accept(update, foo);

        return save(foo);
    }

    @Transactional
    public void delete(Long id) {
        fooRepository.deleteById(id);
    }
}
