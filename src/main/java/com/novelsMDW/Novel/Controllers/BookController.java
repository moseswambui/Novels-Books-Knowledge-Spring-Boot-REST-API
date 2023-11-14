package com.novelsMDW.Novel.Controllers;

import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Service.BookService;
import com.novelsMDW.Novel.requests.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
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

}
