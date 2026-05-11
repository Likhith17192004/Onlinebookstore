# Online Bookstore

A full-stack Spring Boot web application for browsing books, viewing details, adding items to cart, and checkout.

## Tech Stack

- Java 17
- Spring Boot
- Spring MVC + Thymeleaf
- Spring Data JPA
- H2 Database (in-memory for easy demo)
- Maven Wrapper

## Run Locally

### Windows

```powershell
.\mvnw.cmd spring-boot:run
```

### Mac/Linux

```bash
./mvnw spring-boot:run
```

Open: `http://localhost:8080/`

## Project Features

- Browse book catalog with cover images
- Search by title/author
- Book details page
- Add and remove cart items
- Checkout flow
- Seeded sample data (20 books)
- Fallback image handling for broken links

## GitHub Pages Note (For Reviewers)

This repository contains a Java backend application and cannot run directly on GitHub Pages.

For easier review, a static project showcase page is provided in:

- `docs/index.html`

Enable GitHub Pages from repository settings (`main` branch, `/docs` folder) to publish the showcase page.

## Repository

Source code: [https://github.com/Likhith17192004/Onlinebookstore](https://github.com/Likhith17192004/Onlinebookstore)
