package com.nhandinhvan.identity_service.controller;

import com.nhandinhvan.identity_service.dto.request.user_request.UserCreationRequest;
import com.nhandinhvan.identity_service.dto.request.user_request.UserUpdateRequest;
import com.nhandinhvan.identity_service.dto.response.ApiResponse;
import com.nhandinhvan.identity_service.dto.response.UserResponse;
import com.nhandinhvan.identity_service.entity.User;
import com.nhandinhvan.identity_service.mapper.UserMapper;
import com.nhandinhvan.identity_service.repository.UserRepository;
import com.nhandinhvan.identity_service.service.user_service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserController
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
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;
    UserRepository userRepository;
    UserMapper userMapper;

    @PostMapping()
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userMapper.toUserResponse(userService.createUser(request)));
        return apiResponse;
    }

    @GetMapping()
    List<UserResponse> getUsers(){
        return userService.getUsers().stream().map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId){
        return ApiResponse.<UserResponse>builder()
                .result(userMapper.toUserResponse(userService.getUser(userId)))
                .build();
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@RequestBody UserUpdateRequest request, @PathVariable("userId") String userId){
        return userMapper.toUserResponse(userService.updateUser(userId, request));
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return "User has been deleted !";
    }
}
