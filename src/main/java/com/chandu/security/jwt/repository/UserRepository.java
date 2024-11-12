package com.chandu.security.jwt.repository;

import com.chandu.security.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    User findByUsername(String username);
}
