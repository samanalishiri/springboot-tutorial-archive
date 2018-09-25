package com.springboot.tutorial.client.service;

import com.springboot.tutorial.client.domain.ClientUser;
import com.springboot.tutorial.client.domain.ClientUserDetails;
import com.springboot.tutorial.client.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<ClientUser> user = repository.findByUsername(username);

        if (!user.isPresent())
            throw new UsernameNotFoundException("invalid username or password");

        return new ClientUserDetails(user.get());
    }
}