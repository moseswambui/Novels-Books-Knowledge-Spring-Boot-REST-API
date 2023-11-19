package com.novelsMDW.Novel.Entities;

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

    @OneToMany(mappedBy = "userProfile")
    private List<Reviews> reviews = new ArrayList<>();
}
