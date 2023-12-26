package com.pj.hibernate.entity.listener.repository;

import com.pj.hibernate.entity.listener.domain.MaterializedBookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterializedBookAuthorRepository extends JpaRepository<MaterializedBookAuthor, Long> {
    List<MaterializedBookAuthor> findByAuthorId(Long authorId);
}
