package com.novelsMDW.Novel.requests;

import com.novelsMDW.Novel.Entities.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {
    private String name;
    private String email;
    private String biography;
    private Date birthDate;


}
