package com.pj.hibernate.entity.listener.dto;

public record BookCreateRequestDTO(String title, String isbn, Integer edition, Integer yearOfPublication, String publisher,
                                   String firstName, String lastName, String email, String phoneNumber) {
}
