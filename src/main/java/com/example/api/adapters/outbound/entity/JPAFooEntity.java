package com.example.api.adapters.outbound.entity;

import com.example.api.domain.Foo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class JPAFooEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String env;

    private Integer quantity;

    private LocalDateTime created;

    public JPAFooEntity(Foo foo) {
        this.id = foo.getId();
        this.env = foo.getEnv();
        this.quantity = foo.getQuantity();
        this.created = foo.getCreated();
    }

}
