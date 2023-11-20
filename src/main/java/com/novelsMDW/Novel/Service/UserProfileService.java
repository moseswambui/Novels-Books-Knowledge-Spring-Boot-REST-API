package com.novelsMDW.Novel.Service;

import com.novelsMDW.Novel.Entities.UserProfile;
import com.novelsMDW.Novel.Repositories.UserProfileRepository;
import com.novelsMDW.Novel.requests.UserProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile addUserProfile(UserProfileRequest userProfileRequest){
        UserProfile userProfile = new UserProfile();

        userProfile.setFirstName(userProfileRequest.getFirstName());
        userProfile.setLastName(userProfileRequest.getLastName());
        userProfile.setPhoneNumber(userProfileRequest.getPhoneNumber());

        UserProfile savedUserProfile = userProfileRepository.save(userProfile);

        return savedUserProfile;
    }
    public UserProfile getUserProfileById(Long id){
        UserProfile userProfile = userProfileRepository.findById(id).get();
        return userProfile;
    }

    public void deleteUserProfile(Long id){
        UserProfile userProfile = userProfileRepository.findById(id).get();
        userProfileRepository.delete(userProfile);
    }

    public List<UserProfile> getAllUserProfiles(){
        return userProfileRepository.findAll();
    }

    /*
    SOLVING N + 1 problem
     */
    public List<UserProfile> getAllUserProfilesWithReviews() {
        return userProfileRepository.findAllUserProfilesWithReviews();
    }
}
