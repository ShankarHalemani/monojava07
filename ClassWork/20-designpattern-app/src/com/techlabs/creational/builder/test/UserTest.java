package com.techlabs.creational.builder.test;

import com.techlabs.creational.builder.model.User;

public class UserTest {
    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .setUserId("1234")
                .setUserEmail("shankara@gmail.com")
                .setUserName("Shanks")
                .builder();

        System.out.println(user);

       User user1 = new User.UserBuilder()
               .setUserId("3456")
               .setUserName("Ethan")
               .builder();

        System.out.println(user1);

//       User user2 = User.UserBuilder.build()
//               .setUserName("Shankar")
//               .builder();
//
//        System.out.println(user2);

    }
}
