package com.novelsMDW.Novel.Controllers.NProblem;

import com.novelsMDW.Novel.DTOs.AuthorDTO;
import com.novelsMDW.Novel.DTOs.NProblem.AuthorBookDTO;
import com.novelsMDW.Novel.Service.AuthorService;
import com.novelsMDW.Novel.Service.NProblem.AuthorBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorBookController {

    private final AuthorBookService authorBookService;

    public AuthorBookController(AuthorBookService authorBookService){
        this.authorBookService = authorBookService;
    }

    @GetMapping("/{authorId}/books")
    public ResponseEntity<AuthorBookDTO> getBooksByAuthor(@PathVariable Long authorId){
        AuthorBookDTO authorBookDTO = authorBookService.getBooksByAuthor(authorId);
        return ResponseEntity.ok(authorBookDTO);
    }
}
