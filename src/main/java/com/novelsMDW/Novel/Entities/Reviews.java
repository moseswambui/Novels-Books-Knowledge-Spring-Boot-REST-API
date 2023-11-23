package com.novelsMDW.Novel.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;

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

    @Transient
    private int reviewAge;

    public void calculateBookAge(){
        if (reviewDate != null){
            Instant reviewInstant = reviewDate.toInstant();
            Instant currentInstant = Instant.now();
            Duration duration = Duration.between(reviewInstant, currentInstant);

            Long days = duration.toDays();

            reviewAge = (int)(days / 365);
        }
    }
}
