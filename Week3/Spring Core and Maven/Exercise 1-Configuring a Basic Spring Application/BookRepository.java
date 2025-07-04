package com.library.repository;

public class BookRepository {
    public String findBookById(String id) {
        return "Found book with ID: " + id;
    }
}