package com.novelsMDW.Novel.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_profile")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.PERSIST)
    @JsonManagedReference(value = "user-reviews")
    private List<Reviews> reviews = new ArrayList<>();
}
