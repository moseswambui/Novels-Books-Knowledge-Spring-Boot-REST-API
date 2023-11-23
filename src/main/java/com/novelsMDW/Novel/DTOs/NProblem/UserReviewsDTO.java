package com.novelsMDW.Novel.DTOs.NProblem;

import com.novelsMDW.Novel.DTOs.ReviewsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReviewsDTO {
    private Long userId;
    private String userName;
    private List<ReviewsDTO> reviews;
    //private BookDTO book;
}
