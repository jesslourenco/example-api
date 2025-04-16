package com.example.api.adapters.outbound.repository;

import com.example.api.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository  extends JpaRepository<Foo, Long> {

}
