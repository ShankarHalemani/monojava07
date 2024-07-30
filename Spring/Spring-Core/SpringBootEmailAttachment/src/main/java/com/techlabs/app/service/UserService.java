package com.techlabs.app.service;

import com.techlabs.app.domain.User;

public interface UserService {
    User saveUser(User user);

    Boolean verifyToken(String token);
}
