package com.nhandinhvan.identity_service.service.user_service;

import com.nhandinhvan.identity_service.dto.request.user_request.UserCreationRequest;
import com.nhandinhvan.identity_service.dto.request.user_request.UserUpdateRequest;
import com.nhandinhvan.identity_service.entity.User;
import com.nhandinhvan.identity_service.exception.AppException;
import com.nhandinhvan.identity_service.exception.ErrorCode;
import com.nhandinhvan.identity_service.mapper.UserMapper;
import com.nhandinhvan.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 * <p>
 * Version 1.0
 * <p>
 * Date:  10/13/2024
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 10/13/2024    NhanDinhVan    Create
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public User createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("User exited !");

        User user = userMapper.toUser(request);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(()->
            new AppException(ErrorCode.USER_NOT_EXISTED)
        );
    }

    @Override
    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);

        userMapper.updateUser(user, request);

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

}
