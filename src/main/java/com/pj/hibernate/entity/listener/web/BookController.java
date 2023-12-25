package com.pj.hibernate.entity.listener.web;

import com.pj.hibernate.entity.listener.domain.Book;
import com.pj.hibernate.entity.listener.dto.BookCreateRequestDTO;
import com.pj.hibernate.entity.listener.dto.BookUpdateRequestDTO;
import com.pj.hibernate.entity.listener.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Provides a REST API endpoints for the Book entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Find all Books in the database.
     *
     * @return list of Books or an empty list if no Books are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/find/all")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/create")
    public Book createNewBook(@RequestBody BookCreateRequestDTO request) {
        return bookService.create(request);
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/update")
    public Book updateBook(@RequestBody BookUpdateRequestDTO request) {
        return bookService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(Long id) {
        bookService.delete(id);
    }
}
