package com.example.api.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Foo {

    private Long id;

    private String env;

    private Integer quantity;

    private LocalDateTime created;

    public Foo(Long id, String env, Integer quantity, LocalDateTime created) {
        this.id = id;
        this.env = env;
        this.quantity = quantity;
        this.created = created;
    }

    public Foo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foo foo = (Foo) o;
        return Objects.equals(id, foo.id) && Objects.equals(env, foo.env) && Objects.equals(quantity, foo.quantity) && Objects.equals(created, foo.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, env, quantity);
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", env='" + env + '\'' +
                ", quantity=" + quantity +
                ", created=" + created +
                '}';
    }
}