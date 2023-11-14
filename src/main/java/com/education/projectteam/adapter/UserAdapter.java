package com.education.projectteam.adapter;

import com.education.projectteam.Dto.UserDto;
import com.education.projectteam.models.User;

public class UserAdapter {
    public static UserDto toDto(User user) {
        String names[] = user.getName().split(" ");
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(names[0])
                .lastName(names[1])
                .nickname(user.getNickname())
                .linkSocial(user.getLinkSocial())
                .location(user.getLocation())
                .university(user.getUniversity())
                .password(user.getPassword())
                .build();
    }
}
