package com.shop.espringshop.service;

import com.shop.espringshop.exception.UserException;
import com.shop.espringshop.model.User;


public interface UserService {

    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;
}
