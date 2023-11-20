package com.novelsMDW.Novel.Controllers;

import com.novelsMDW.Novel.Entities.UserProfile;
import com.novelsMDW.Novel.Service.UserProfileService;
import com.novelsMDW.Novel.requests.UserProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/profiles")
@RequiredArgsConstructor
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/add")
    public UserProfile addUserProfile(@RequestBody UserProfileRequest userProfileRequest){
        return userProfileService.addUserProfile(userProfileRequest);
    }

    @GetMapping("/{id}")
    public UserProfile getUserProfile(@PathVariable Long id){
        return userProfileService.getUserProfileById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProfile(@PathVariable Long id){
        userProfileService.deleteUserProfile(id);
    }

    @GetMapping("/all")
    public List<UserProfile> getAllUserProfiles(){
        return userProfileService.getAllUserProfiles();
    }

    @GetMapping("/with-reviews")
    public List<UserProfile> getAllUserProfilesWithReviews() {
        return userProfileService.getAllUserProfilesWithReviews();
    }
}
