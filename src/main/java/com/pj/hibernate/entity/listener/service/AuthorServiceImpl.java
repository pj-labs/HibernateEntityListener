package com.pj.hibernate.entity.listener.service;

import com.pj.hibernate.entity.listener.domain.Author;
import com.pj.hibernate.entity.listener.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @param author
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    /**
     * Updates an existing Book in the database.
     *
     * @param author
     *
     * @return the updated Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }
}
