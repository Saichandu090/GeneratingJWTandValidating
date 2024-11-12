package com.chandu.security.jwt.controller;

import com.chandu.security.jwt.model.User;
import com.chandu.security.jwt.service.JWTService;
import com.chandu.security.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("register")
    public User register(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user)
    {
        Authentication authentication=
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(user.getUsername());
        }
        else
          return   "Login Failed!!";
    }
}
