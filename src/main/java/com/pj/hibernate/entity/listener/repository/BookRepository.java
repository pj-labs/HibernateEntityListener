package com.pj.hibernate.entity.listener.repository;

import com.pj.hibernate.entity.listener.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteByIsbn(String isbn);

    Book findByIsbn(String isbn);
}
