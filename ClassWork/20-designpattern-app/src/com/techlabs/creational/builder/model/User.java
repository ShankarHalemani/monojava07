package com.techlabs.creational.builder.model;

public class User {
    private final String userId;
    private final String userName;
    private final String userEmail;

    private User(UserBuilder userBuilder){
        //Initialize
        this.userId=userBuilder.userId;
        this.userName=userBuilder.userName;
        this.userEmail=userBuilder.userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public String toString() {
        return "\n{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    //Inner class to create object
    public static class UserBuilder{

        private String userId;
        private String userName;
        private String userEmail;

//        public static UserBuilder build(){
//            return new UserBuilder();
//        }

        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public User builder(){
            return new User(this);
        }

    }
}
