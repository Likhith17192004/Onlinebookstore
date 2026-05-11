package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.entity.Book;
import com.example.onlinebookstore.entity.Cart;
import com.example.onlinebookstore.repository.BookRepository;
import com.example.onlinebookstore.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookstoreApiController {

    private final BookRepository bookRepository;
    private final CartRepository cartRepository;

    public BookstoreApiController(BookRepository bookRepository, CartRepository cartRepository) {
        this.bookRepository = bookRepository;
        this.cartRepository = cartRepository;
    }

    // GET /api/books -> Fetch all books
    @GetMapping("/api/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // GET /api/books/{id} -> Fetch book details (JSON)
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public record AddToCartRequest(Long bookId) {}

    // POST /api/cart -> Add book to cart
    @PostMapping("/api/cart")
    public ResponseEntity<Cart> addToCart(@RequestBody AddToCartRequest request) {
        if (request == null || request.bookId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Book book = bookRepository.findById(request.bookId()).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        Cart cart = new Cart(book.getTitle(), book.getPrice(), book.getImage());
        return ResponseEntity.ok(cartRepository.save(cart));
    }

    // GET /api/cart -> Get cart (JSON)
    @GetMapping("/api/cart")
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    // DELETE /api/cart/{id} -> Remove item
    @DeleteMapping("/api/cart/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        if (!cartRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cartRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST /api/checkout -> Place order (clears cart)
    @PostMapping("/api/checkout")
    public Map<String, Object> checkout() {
        double total = cartRepository.findAll().stream().mapToDouble(Cart::getPrice).sum();
        cartRepository.deleteAll();
        return Map.of(
                "message", "Order placed successfully",
                "total", total
        );
    }
}

