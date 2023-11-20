package com.novelsMDW.Novel.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsDTO {
    private Long reviewId;
    private Date reviewDate;
    private String description;
    private Long userProfileId;
    private Long bookId;
}
