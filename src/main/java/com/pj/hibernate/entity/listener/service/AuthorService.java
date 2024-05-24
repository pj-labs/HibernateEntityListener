package com.pj.hibernate.entity.listener.service;

import com.pj.hibernate.entity.listener.domain.Author;

public interface AuthorService {

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Author create(Author author);

    /**
     * Updates an existing Book in the database.
     *
     * @return the updated Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Author update(Author author);
}
