package com.education.projectteam.service;

import com.education.projectteam.Dto.UserDto;
import com.education.projectteam.models.User;
import com.education.projectteam.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}