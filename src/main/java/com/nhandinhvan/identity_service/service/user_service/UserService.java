package com.nhandinhvan.identity_service.service.user_service;

import com.nhandinhvan.identity_service.dto.request.user_request.UserCreationRequest;
import com.nhandinhvan.identity_service.dto.request.user_request.UserUpdateRequest;
import com.nhandinhvan.identity_service.entity.User;

import java.util.List;

/**
 * UserService
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

public interface UserService {
    public User createUser(UserCreationRequest request);
    public List<User> getUsers();
    public User getUser(String id);
    public User updateUser(String userId, UserUpdateRequest request);
    public void deleteUser(String userId);
}
