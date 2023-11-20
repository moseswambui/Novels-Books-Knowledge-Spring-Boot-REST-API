package com.novelsMDW.Novel.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {

    private Long profileId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Long> reviewIds;
}
