package com.novelsMDW.Novel.Service;

import com.novelsMDW.Novel.Entities.UserProfile;
import com.novelsMDW.Novel.Repositories.UserProfileRepository;
import com.novelsMDW.Novel.requests.UserProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

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

    
}
