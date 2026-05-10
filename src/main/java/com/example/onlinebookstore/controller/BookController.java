package com.example.onlinebookstore.controller;
import com.example.onlinebookstore.entity.Cart;
import com.example.onlinebookstore.repository.CartRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.onlinebookstore.entity.Book;
import com.example.onlinebookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
private CartRepository cartRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";

        
    }
    @GetMapping("/add")
public String addBookPage() {
    return "add-book";
}

@PostMapping("/save")
public String saveBook(@ModelAttribute Book book) {

    bookRepository.save(book);

    return "redirect:/";
}
@GetMapping("/delete/{id}")
public String deleteBook(@PathVariable Long id) {
    bookRepository.deleteById(id);
    return "redirect:/";
}
@GetMapping("/cart/add/{id}")
public String addToCart(@PathVariable Long id) {

    Book book = bookRepository.findById(id).orElse(null);

    if(book != null) {

        Cart cart = new Cart(
                book.getTitle(),
                book.getPrice(),
                book.getImage()
        );

        cartRepository.save(cart);
    }

    return "redirect:/";
}

@GetMapping("/cart")
public String showCart(Model model){

    model.addAttribute("cartItems",
            cartRepository.findAll());

    return "cart";
}

@GetMapping("/cart/delete/{id}")
public String removeFromCart(@PathVariable Long id){

    cartRepository.deleteById(id);

    return "redirect:/cart";
}
}