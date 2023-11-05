package com.novelsMDW.Novel.Controllers;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Service.AuthorService;
import com.novelsMDW.Novel.requests.AuthorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
