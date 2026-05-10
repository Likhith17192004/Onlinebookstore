package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}