package com.springboot.tutorial.profile.service;

import com.springboot.tutorial.profile.profile.ProfileName;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(ProfileName.DEVELOPMENT)
public class DevelopmentService implements AbstractService {

    @Override
    public void print() {
        System.out.println("profile = " + ProfileName.DEVELOPMENT);
    }
}
