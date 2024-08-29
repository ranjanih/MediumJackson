package com.medium.util;

import com.medium.userdetails.model.UserData;
import com.medium.userdetails.model.UserType;
import com.medium.userdetails.model.UserTypeData;

import java.util.Map;

public class MockedUsersUtility {

    public static UserData getMockedUserData() {
        return new UserData(100L, "Ranjani", "Harish", "Sydney");
    }

    public static Map<String, String> getMockedUserDataMap() {
        return Map.of("id", "100", "firstName","Ranjani", "lastName","Harish", "city","Sydney");
    }

    public static UserTypeData getMockedUserTypeData() {
        UserData ud = new UserData(100L, "Ranjani", "Harish", "Sydney");
        UserType ut = UserType.EXTERNAL;
        return new UserTypeData(ud, ut);
    }

    public static String userDataObjectAsString() {
        return getMockedUserData().toString();
    }
}
