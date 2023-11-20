package com.novelsMDW.Novel.Service;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Entities.Category;
import com.novelsMDW.Novel.Repositories.AuthorRepository;
import com.novelsMDW.Novel.Repositories.BookRepository;
import com.novelsMDW.Novel.requests.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setDescription(bookRequest.getDescription());
        book.setLanguage(bookRequest.getLanguage());
        book.setPublishDate(bookRequest.getPublishDate());
        book.setPage(bookRequest.getPage());
        book.setAuthor(authorRepository.findById(bookRequest.getAuthorId()).orElseThrow(() ->
                new RuntimeException("Author Not Found")));

        Book savedBook = bookRepository.save(book);

        return savedBook;
    }

    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).get();
        return book;
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByCategory(Category category) {

        return bookRepository.findAllByCategory(category);
    }

    public List<Book> getBooksByAuthor(Author author) {

        return bookRepository.findAllByAuthor(author);
    }

    public List<Book> findBooksByName(String name) {
        return bookRepository.findByName(name);
    }

    public List<Book> getAllBooksWithReviews() {
        return bookRepository.findAllWithReviews();
    }

    public List<Book> getAllBooksWithReviewsAndUsers(){
        return bookRepository.findAll();
    }

    public List<Book> getAllBooksWithCategories() {
        return bookRepository.findAll();
    }
}
