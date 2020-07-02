package com.schola.domain.user;


public class UserService {

    private UserGateway userGateway;

    public User doAuth(String username , String password){
        return userGateway.autoLogin(username, password);
    }

}
