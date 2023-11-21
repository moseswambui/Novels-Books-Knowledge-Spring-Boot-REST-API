package com.novelsMDW.Novel.Service;

import com.novelsMDW.Novel.DTOs.AuthorDTO;
import com.novelsMDW.Novel.DTOs.BookDTO;
import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Entities.Category;
import com.novelsMDW.Novel.Repositories.AuthorRepository;
import com.novelsMDW.Novel.Repositories.BookRepository;
import com.novelsMDW.Novel.Repositories.CategoryRepository;
import com.novelsMDW.Novel.requests.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private final AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    public BookService(){
        this.bookRepository = null;
        this.authorService = new AuthorService();
        this.authorRepository = null;
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

        if (bookRequest.getCategories() != null){
            Set<Category> categories = new HashSet<>();
            for (Long categoryId : bookRequest.getCategories()){
                Category category = categoryRepository.findById(categoryId)
                        .orElseThrow(() -> new RuntimeException("Category Not Found"));
                categories.add(category);
            }
            book.setCategories(categories);
        }
        if(bookRequest.getLibrary() != null){
            book.setLibraries(Collections.singleton(bookRequest.getLibrary()));
        }

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

    //DTO Implementation. Presentation Layer Impl

    public List<BookDTO> getAllBooksWithCategoriesAndAuthorInfo(){
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertToBookDTO).collect(Collectors.toList());
    }

    private BookDTO convertToBookDTO(Book book){
        BookDTO bookDTO = new BookDTO();

        bookDTO.setBookId(book.getBookId());
        bookDTO.setName(book.getName());
        bookDTO.setCategoryIds(book.getCategories().stream().map(Category::getCategoryId).collect(Collectors.toSet()));
        bookDTO.setPublishDate(book.getPublishDate());
        bookDTO.setDescription(book.getDescription());

        //Author author = authorService.getAuthorById(book.getAuthor().getAuthorId());

        //if (author != null){
            //AuthorDTO authorDTO = convertToAuthorDTO(author);
            //bookDTO.setAuthorId(authorDTO.getAuthorId());
        //}
        return bookDTO;
    }

    private AuthorDTO convertToAuthorDTO(Author author){
        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setAuthorId(author.getAuthorId());
        authorDTO.setName(author.getName());
        authorDTO.setEmail(author.getEmail());

        return authorDTO;
    }
}
