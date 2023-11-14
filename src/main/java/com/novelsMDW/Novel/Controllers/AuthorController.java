package com.novelsMDW.Novel.Controllers;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Service.AuthorService;
import com.novelsMDW.Novel.requests.AuthorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
     private AuthorService authorService;

    @PostMapping("/add")
    public Author addAuthor(@RequestBody AuthorRequest authorRequest){
        return authorService.addAuthor(authorRequest);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }

    @GetMapping(value = "/search", produces = "application/json")
    public List<Author> findAuthorsByName(@RequestParam String name){
        return authorService.findAuthorsByName(name);
    }

    @GetMapping("search-author")
    public ResponseEntity<List<Author>> findAuthorByName(@RequestParam String name){
        List<Author> authors = authorService.findAuthorsByName(name);
        if (authors.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if no authors found.
        } else {
            return ResponseEntity.ok(authors); // Return 200 OK with the list of authors.
        }
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }
}
