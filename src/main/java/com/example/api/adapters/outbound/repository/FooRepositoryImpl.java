package com.example.api.adapters.outbound.repository;

import com.example.api.adapters.outbound.entity.JPAFooEntity;
import com.example.api.domain.Foo;
import com.example.api.domain.FooRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FooRepositoryImpl implements FooRepository {
    private final JPAFooRepository jpaFooRepository;

    public FooRepositoryImpl(JPAFooRepository jpaFooRepository) {
        this.jpaFooRepository = jpaFooRepository;
    }

    @Override
    public List<Foo> findAll() {
        return jpaFooRepository.findAll().stream()
                .map(e -> new Foo(e.getId(), e.getEnv(), e.getQuantity(), e.getCreated()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Foo> findById(Long id) {
        Optional<JPAFooEntity> jpaFooEntity = jpaFooRepository.findById(id);
        return jpaFooEntity.map(e -> new Foo(e.getId(), e.getEnv(), e.getQuantity(), e.getCreated()));
    }

    @Override
    public Foo save(Foo foo) {
        JPAFooEntity jpaFooEntity = new JPAFooEntity(foo);
        jpaFooRepository.save(jpaFooEntity);
        return new Foo(jpaFooEntity.getId(), jpaFooEntity.getEnv(), jpaFooEntity.getQuantity(), jpaFooEntity.getCreated());
    }

    @Override
    public boolean existsById(Long id) {
        return jpaFooRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaFooRepository.deleteById(id);
    }
}
