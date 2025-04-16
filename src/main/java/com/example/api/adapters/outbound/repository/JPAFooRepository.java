package com.example.api.adapters.outbound.repository;

import com.example.api.adapters.outbound.entity.JPAFooEntity;
import com.example.api.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAFooRepository extends JpaRepository<JPAFooEntity, Long> {

}
