package com.pj.hibernate.entity.listener.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "materialized_book_author")
@Data
@NoArgsConstructor
public class MaterializedBookAuthor {
    @Id
    private Long bookId;
    private String title;
    private String isbn;
    private Integer edition;
    private Integer yearOfPublication;
    private String publisher;
    private Long authorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public MaterializedBookAuthor(Long bookId) {
        this.bookId = bookId;
    }
}
