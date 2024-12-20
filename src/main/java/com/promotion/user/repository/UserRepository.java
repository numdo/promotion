package com.promotion.user.repository;

import com.promotion.user.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDto, Long> {
    UserDto findByUserId(String username);
}
