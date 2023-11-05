package com.novelsMDW.Novel.Service;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Repositories.AuthorRepository;
import com.novelsMDW.Novel.requests.AuthorRequest;
import com.novelsMDW.Novel.requests.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(AuthorRequest authorRequest){
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setEmail(authorRequest.getEmail());
        author.setBiography(authorRequest.getBiography());
        author.setBirthDate(authorRequest.getBirthDate());

        Author savedAuthor = authorRepository.save(author);
        return savedAuthor;

    }

    public Author getAuthorById(Long id){
        Author author = authorRepository.findById(id).get();
        return author;
    }

    public void deleteAuthor(Long id){
        Author author = new Author();
        authorRepository.delete(author);
    }
}
