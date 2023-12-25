package com.pj.hibernate.entity.listener.service;

import com.pj.hibernate.entity.listener.domain.Book;
import com.pj.hibernate.entity.listener.dto.BookCreateRequestDTO;
import com.pj.hibernate.entity.listener.dto.BookUpdateRequestDTO;

import java.util.List;

public interface BookService {
    Book findById(Long id);

    /**
     * Find all Books in the database.
     *
     * @return list of Books or an empty list if no Books are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    List<Book> findAll();

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Book create(BookCreateRequestDTO request);

    /**
     * Updates an existing Book in the database.
     *
     * @return the updated Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Book update(BookUpdateRequestDTO request);

    void delete(Long id);


}
