package com.novelsMDW.Novel.Controllers;

import com.novelsMDW.Novel.DTOs.BookDTO;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Service.BookService;
import com.novelsMDW.Novel.requests.BookRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@AllArgsConstructor

public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping("/add")
    public Book addBook(@RequestBody BookRequest bookRequest){

        return bookService.addBook(bookRequest);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return  bookService.getAllBooks();
    }

    @GetMapping("/search")
    public List<Book> searchBookByName(@RequestParam String name){
        return  bookService.findBooksByName(name);
    }

    @GetMapping("/with-reviews")
    public List<Book> getAllBooksWithReviews() {
        return bookService.getAllBooksWithReviews();
    }

    @GetMapping("allWithReviewsAndUsers")
    public ResponseEntity<List<Book>> getAllBooksWithReviewsAndUsers(){
        List<Book> books = bookService.getAllBooksWithReviewsAndUsers();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/with-categories")
    public ResponseEntity<List<Book>> getAllBooksWithCategories(){
        List<Book> books = bookService.getAllBooksWithCategories();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    //WITH DTOs - PRESENTATION Layer

    @GetMapping("/with-categories-and-author-info")
    public ResponseEntity<List<BookDTO>> getAllBooksWithCategoriesAndAuthorInfo(){
        List<BookDTO> bookDTOs = bookService.getAllBooksWithCategoriesAndAuthorInfo();
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }
}
