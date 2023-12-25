package com.pj.hibernate.entity.listener.dto;

public record BookUpdateRequestDTO(String title, String isbn, Integer edition, Integer yearOfPublication, String publisher, Long bookTypeId, Long authorId) {
}
