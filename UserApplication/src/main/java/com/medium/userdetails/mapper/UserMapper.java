package com.medium.userdetails.mapper;

import com.medium.userdetails.model.UserData;
import com.medium.userdetails.persistence.User;

import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {

    public static List<UserData> usersToUserData(List<User> users) {
        return users.stream().map(user -> new UserData(user.getId(),
                user.getFirstName(), user.getLastName(), user.getCity())).collect(Collectors.toList());
    }

}
