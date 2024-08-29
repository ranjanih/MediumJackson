package com.medium.userdetails.service;

import com.medium.userdetails.mapper.UserMapper;
import com.medium.userdetails.model.UserData;
import com.medium.userdetails.persistence.User;
import com.medium.userdetails.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserData> getUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.usersToUserData(users);
    }
}
