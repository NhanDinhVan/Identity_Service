package com.nhandinhvan.identity_service.mapper;

import com.nhandinhvan.identity_service.dto.request.user_request.UserCreationRequest;
import com.nhandinhvan.identity_service.dto.request.user_request.UserUpdateRequest;
import com.nhandinhvan.identity_service.dto.response.UserResponse;
import com.nhandinhvan.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * UserMapper
 * <p>
 * Version 1.0
 * <p>
 * Date:  10/29/2024
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 10/29/2024    NhanDinhVan    Create
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

//    @Mapping(source = "firstName", target = "lastName")
//    @Mapping(target = "lastName", ignore = true)
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
