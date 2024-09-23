package com.shop.espringshop.service.impl;

import com.shop.espringshop.config.JwtProvider;
import com.shop.espringshop.exception.UserException;
import com.shop.espringshop.model.User;
import com.shop.espringshop.repository.UserRepository;
import com.shop.espringshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public UserServiceImplementation(final UserRepository userRepository,
                                     final JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }
    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            return user.get();
        }
        throw new UserException("User nor found with id - "+userId);
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {

        String email = jwtProvider.getEmailFromToken(jwt);
        User user = userRepository.findByEmail(email);

        if(user==null){
            throw new UserException("User not found with email - "+email);
        }

        return user;
    }
}
