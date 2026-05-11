package com.example.onlinebookstore.config;

import com.example.onlinebookstore.entity.Book;
import com.example.onlinebookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleDataSeeder implements CommandLineRunner {

    private final BookRepository bookRepository;

    public SampleDataSeeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        // Keep demo data stable and remove old rows with broken cover links.
        bookRepository.deleteAll();

        List<Book> seed = List.of(
                new Book(
                        "Clean Code",
                        "Robert C. Martin",
                        699.00,
                        "A practical handbook of agile software craftsmanship.",
                        "https://covers.openlibrary.org/b/isbn/9780132350884-L.jpg"
                ),
                new Book(
                        "The Pragmatic Programmer",
                        "Andrew Hunt, David Thomas",
                        799.00,
                        "Timeless tips for pragmatic programmers.",
                        "https://covers.openlibrary.org/b/isbn/9780135957059-L.jpg"
                ),
                new Book(
                        "Designing Data-Intensive Applications",
                        "Martin Kleppmann",
                        999.00,
                        "Storage, streams, consistency, and scalable system design.",
                        "https://covers.openlibrary.org/b/isbn/9781449373320-L.jpg"
                ),
                new Book(
                        "Atomic Habits",
                        "James Clear",
                        499.00,
                        "An easy & proven way to build good habits and break bad ones.",
                        "https://covers.openlibrary.org/b/isbn/9780735211292-L.jpg"
                ),
                new Book(
                        "Deep Work",
                        "Cal Newport",
                        549.00,
                        "Rules for focused success in a distracted world.",
                        "https://covers.openlibrary.org/b/isbn/9781455586691-L.jpg"
                ),
                new Book(
                        "The Alchemist",
                        "Paulo Coelho",
                        299.00,
                        "A timeless story about following your dreams.",
                        "https://covers.openlibrary.org/b/isbn/9780061122415-L.jpg"
                ),
                new Book(
                        "Rich Dad Poor Dad",
                        "Robert T. Kiyosaki",
                        349.00,
                        "What the rich teach their kids about money.",
                        "https://covers.openlibrary.org/b/isbn/9781612681139-L.jpg"
                ),
                new Book(
                        "Think and Grow Rich",
                        "Napoleon Hill",
                        279.00,
                        "Classic guide to success mindset and habits.",
                        "https://covers.openlibrary.org/b/isbn/9781585424337-L.jpg"
                ),
                new Book(
                        "The Psychology of Money",
                        "Morgan Housel",
                        399.00,
                        "Timeless lessons on wealth, greed, and happiness.",
                        "https://covers.openlibrary.org/b/isbn/9780857197689-L.jpg"
                ),
                new Book(
                        "Ikigai",
                        "Héctor García, Francesc Miralles",
                        329.00,
                        "The Japanese secret to a long and happy life.",
                        "https://covers.openlibrary.org/b/isbn/9781786330895-L.jpg"
                ),
                new Book(
                        "Sapiens",
                        "Yuval Noah Harari",
                        599.00,
                        "A brief history of humankind.",
                        "https://covers.openlibrary.org/b/isbn/9780062316110-L.jpg"
                ),
                new Book(
                        "Homo Deus",
                        "Yuval Noah Harari",
                        649.00,
                        "A brief history of tomorrow.",
                        "https://covers.openlibrary.org/b/isbn/9780062464316-L.jpg"
                ),
                new Book(
                        "The Hobbit",
                        "J.R.R. Tolkien",
                        399.00,
                        "A fantasy adventure that precedes The Lord of the Rings.",
                        "https://covers.openlibrary.org/b/isbn/9780547928227-L.jpg"
                ),
                new Book(
                        "1984",
                        "George Orwell",
                        249.00,
                        "A dystopian classic about surveillance and control.",
                        "https://covers.openlibrary.org/b/isbn/9780451524935-L.jpg"
                ),
                new Book(
                        "The Great Gatsby",
                        "F. Scott Fitzgerald",
                        199.00,
                        "A classic novel of the Jazz Age.",
                        "https://covers.openlibrary.org/b/isbn/9780743273565-L.jpg"
                ),
                new Book(
                        "To Kill a Mockingbird",
                        "Harper Lee",
                        299.00,
                        "A powerful novel about justice and morality.",
                        "https://covers.openlibrary.org/b/isbn/9780061120084-L.jpg"
                ),
                new Book(
                        "Pride and Prejudice",
                        "Jane Austen",
                        229.00,
                        "A romantic classic with wit and social commentary.",
                        "https://covers.openlibrary.org/b/isbn/9781503290563-L.jpg"
                ),
                new Book(
                        "The Catcher in the Rye",
                        "J.D. Salinger",
                        279.00,
                        "A coming-of-age story with a unique voice.",
                        "https://covers.openlibrary.org/b/isbn/9780316769488-L.jpg"
                ),
                new Book(
                        "Harry Potter and the Sorcerer's Stone",
                        "J.K. Rowling",
                        499.00,
                        "The first year at Hogwarts begins.",
                        "https://covers.openlibrary.org/b/isbn/9780590353427-L.jpg"
                ),
                new Book(
                        "The Lord of the Rings",
                        "J.R.R. Tolkien",
                        999.00,
                        "An epic fantasy journey through Middle-earth.",
                        "https://covers.openlibrary.org/b/isbn/9780544003415-L.jpg"
                )
        );

        bookRepository.saveAll(seed);
    }
}

