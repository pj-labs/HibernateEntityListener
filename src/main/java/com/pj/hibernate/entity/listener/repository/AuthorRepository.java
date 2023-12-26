package com.pj.hibernate.entity.listener.repository;

import com.pj.hibernate.entity.listener.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
