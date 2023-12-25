package com.pj.hibernate.entity.listener.service;

import com.pj.hibernate.entity.listener.domain.Author;
import com.pj.hibernate.entity.listener.domain.Book;
import com.pj.hibernate.entity.listener.dto.BookCreateRequestDTO;
import com.pj.hibernate.entity.listener.dto.BookUpdateRequestDTO;
import com.pj.hibernate.entity.listener.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Find a Book by id.
     *
     * @param id the id of the Book to find
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    /**
     * Find all Books in the database.
     *
     * @return list of Books or an empty list if no Books are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @param request the Book to create
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Book create(BookCreateRequestDTO request) {
        var book = new Book();
        book.setTitle(request.title());
        book.setIsbn(request.isbn());
        book.setEdition(request.edition());
        book.setYearOfPublication(request.yearOfPublication());
        book.setPublisher(request.publisher());
        book.setAuthors(List.of(new Author(request.firstName(), request.lastName(), request.email(), request.phoneNumber())));
        return bookRepository.saveAndFlush(book);
    }

    /**
     * Updates an existing Book in the database.
     *
     * @param request the Book to update
     *
     * @return the updated Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Book update(BookUpdateRequestDTO request) {
        Book book = bookRepository.findByIsbn(request.isbn());
        book.setTitle(request.title());
        book.setIsbn(request.isbn());
        book.setEdition(request.edition());
        book.setYearOfPublication(request.yearOfPublication());
        book.setPublisher(request.publisher());
        return bookRepository.saveAndFlush(book);
    }

    /**
     * Deletes an existing Book from the database.
     *
     * @param id the id of the Book to delete
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
