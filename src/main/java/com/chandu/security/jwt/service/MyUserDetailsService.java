package com.chandu.security.jwt.service;

import com.chandu.security.jwt.model.User;
import com.chandu.security.jwt.model.UserPrinciple;
import com.chandu.security.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user=repository.findByUsername(username);
        if(user==null)
        {
            System.out.println("User not Found 404");
            throw new UsernameNotFoundException("User Not Found 404");
        }
        else
            return new UserPrinciple(user);
    }
}
