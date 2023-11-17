package com.novelsMDW.Novel.requests;

import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Entities.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsRequest {

    private Date reviewDate;
    private String description;
    private UserProfile userProfile;
    private Book book;
}
