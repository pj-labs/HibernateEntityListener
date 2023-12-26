package com.pj.hibernate.entity.listener.domain;

import com.pj.hibernate.entity.listener.repository.MaterializedBookAuthorRepository;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookEntityListener {
    @Lazy
    @Autowired
    private MaterializedBookAuthorRepository repository;

    public BookEntityListener() {
        // Default constructor
    }

    @PrePersist
    @PreRemove
    @PreUpdate
    @PostLoad
    public void prePersist(Book book) {
        log.debug("PrePersist/PreRemove/PreUpdate/PostLoad book:{}", book);
    }

    @PostRemove
    public void postRemove(Book book) {
        repository.deleteById(book.getId());
    }

    @PostUpdate
    @PostPersist
    public void postUpdate(Book book) {
        var bookMaterialized = repository.findById(book.getId()).orElse(new MaterializedBookAuthor(book.getId()));
        bookMaterialized.setIsbn(book.getIsbn());
        bookMaterialized.setTitle(book.getTitle());
        bookMaterialized.setEdition(book.getEdition());
        bookMaterialized.setYearOfPublication(book.getYearOfPublication());
        bookMaterialized.setPublisher(book.getPublisher());
        bookMaterialized.setFirstName(book.getAuthor().getFirstName());
        bookMaterialized.setLastName(book.getAuthor().getLastName());
        bookMaterialized.setEmail(book.getAuthor().getEmail());
        bookMaterialized.setPhoneNumber(book.getAuthor().getPhoneNumber());
        repository.save(bookMaterialized);

    }
}
