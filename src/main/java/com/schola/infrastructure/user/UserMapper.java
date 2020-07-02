package com.schola.infrastructure.user;

import com.schola.domain.user.User;
import org.mapstruct.factory.Mappers;


public class UserMapper {

    public static final  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    public User toUser(UserEntity userEntity){
        User user = User.builder()
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .password(userEntity.getPassword())
                .build();
        return  user;
    }
}
