package com.example.api.adapters.inbound.controller;

import com.example.api.adapters.outbound.dto.persist.FooPersist;
import com.example.api.adapters.inbound.dto.response.FooResponse;
import com.example.api.adapters.inbound.dto.update.FooPartialUpdate;
import com.example.api.adapters.inbound.dto.update.FooUpdate;
import com.example.api.domain.Foo;
import com.example.api.application.service.FooServiceImpl;
import com.example.api.util.Converter;
import com.example.api.util.Paths;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value =  Paths.FOO_VALUE)
@Tag(name = "Foo")
public class FooController {

    private final FooServiceImpl fooServiceImpl;

    private final Converter converter;

    @GetMapping
    public ResponseEntity<List<FooResponse>> get() {
        return ResponseEntity.ok(converter.mapAll(fooServiceImpl.findAll(), FooResponse.class));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FooResponse> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(converter.map(fooServiceImpl.find(id), FooResponse.class));
    }

    @PostMapping
    public ResponseEntity<FooResponse> post(@Valid @RequestBody FooPersist fooPersist) {
        return ResponseEntity.ok(converter.map(fooServiceImpl.save(converter.map(fooPersist, Foo.class)), FooResponse.class));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FooResponse> put(@PathVariable("id") Long id, @Valid @RequestBody FooUpdate fooUpdate) {
        Foo foo = converter.map(fooUpdate, Foo.class);
        foo.setId(id);
        return  ResponseEntity.ok(converter.map(fooServiceImpl.update(foo), FooResponse.class));
    }


    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FooResponse> patch(@PathVariable("id") Long id, @Valid @RequestBody FooPartialUpdate fooPartialUpdate) {
        Foo foo = converter.map(fooPartialUpdate, Foo.class);
        foo.setId(id);
        return  ResponseEntity.ok(converter.map(fooServiceImpl.partialUpdate(foo), FooResponse.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        fooServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }


}