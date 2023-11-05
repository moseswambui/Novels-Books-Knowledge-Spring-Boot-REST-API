package com.novelsMDW.Novel.Service;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Entities.Category;
import com.novelsMDW.Novel.Repositories.BookRepository;
import com.novelsMDW.Novel.requests.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(BookRequest bookRequest){
        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setDescription(bookRequest.getDescription());
        book.setLanguage(bookRequest.getLanguage());
        book.setPublishDate(bookRequest.getPublishDate());
        book.setPage(bookRequest.getPage());

        Book savedBook = bookRepository.save(book);

        return savedBook;
    }

    public Book getBookById(Long id){
        Book book = bookRepository.findById(id).get();
        return book;
    }
    public void deleteBook(Long id){
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
    }


    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public List<Book> getBooksByCategory(Category category){
        return bookRepository.findAllByCategory(category);
    }

    public List<Book> getBooksByAuthor(Author author){
        return bookRepository.findAllByAuthor(author);
    }

    //ADD MORE SERVICES
}
