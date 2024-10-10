package com.pj.hibernate.entity.listener.domain;

import com.pj.hibernate.entity.listener.repository.MaterializedBookAuthorRepository;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthorEntityListener {
    @Lazy
    @Autowired
    private MaterializedBookAuthorRepository repository;

    public AuthorEntityListener() {
        // Default constructor
    }

    @PrePersist
    @PreRemove
    @PreUpdate
    @PostLoad
    public void prePersist(Author author) {
        log.debug("PrePersist/PreRemove/PreUpdate/PostLoad author:{}", author);
    }

    @PostUpdate
    @PostPersist
    public void postUpdate(Author author) {
        var booksMaterialized = repository.findByAuthorId(author.getId());
        if (!booksMaterialized.isEmpty()) {
            booksMaterialized.forEach(bookMaterialized -> {
                bookMaterialized.setFirstName(author.getFirstName());
                bookMaterialized.setLastName(author.getLastName());
                bookMaterialized.setEmail(author.getEmail());
                bookMaterialized.setPhoneNumber(author.getPhoneNumber());
                repository.save(bookMaterialized);
            });
        }
    }
}