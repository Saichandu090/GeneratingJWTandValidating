package com.chandu.security.jwt.service;

import com.chandu.security.jwt.model.User;
import com.chandu.security.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;

    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User addUser(User user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
