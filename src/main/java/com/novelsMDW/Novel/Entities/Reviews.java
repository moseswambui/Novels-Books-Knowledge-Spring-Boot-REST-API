package com.novelsMDW.Novel.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "reviews")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Date reviewDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    @JsonBackReference
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "user-reviews")
    private Book book;

}
