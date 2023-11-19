package com.novelsMDW.Novel.requests;

import com.novelsMDW.Novel.Entities.Reviews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Reviews reviews;
}
