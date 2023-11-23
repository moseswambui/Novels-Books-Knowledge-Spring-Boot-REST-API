package com.novelsMDW.Novel.Service.NProblem;

import com.novelsMDW.Novel.DTOs.BookDTO;
import com.novelsMDW.Novel.DTOs.NProblem.AuthorBookDTO;
import com.novelsMDW.Novel.DTOs.NProblem.BookListDTO;
import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Repositories.AuthorRepository;
import com.novelsMDW.Novel.Repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthorBookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorBookDTO getBooksByAuthor(Long authorId){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()-> new EntityNotFoundException("Author not Found"));

        List<Book> books = bookRepository.findAllByAuthor(author);

        List<BookListDTO> bookListDTOs = books.stream()
                .map(book -> new BookListDTO(book.getBookId(), book.getName(),book.getDescription()))
                .collect(Collectors.toList());

        return new AuthorBookDTO(
                author.getAuthorId(),
                author.getName(),
                author.getEmail(),
                author.getBiography(),
                bookListDTOs
        );
    }
}
