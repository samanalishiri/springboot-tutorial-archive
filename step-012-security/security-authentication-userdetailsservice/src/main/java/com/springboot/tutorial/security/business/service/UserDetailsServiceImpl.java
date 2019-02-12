package com.springboot.tutorial.security.business.service;

import com.springboot.tutorial.security.business.repository.UserRepository;
import com.springboot.tutorial.security.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Administrator on 9/29/2017.
 */
@Service(UserDetailsServiceImpl.BEAN_NAME)
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final String BEAN_NAME = "userDetailsService";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier(CustomPasswordEncoder.NAME)
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }

    public Optional<UserEntity> save(UserEntity entity){
        String encodedPassword = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(encodedPassword);
        UserEntity user = userRepository.save(entity);

        return Optional.of(user);
    }


}
