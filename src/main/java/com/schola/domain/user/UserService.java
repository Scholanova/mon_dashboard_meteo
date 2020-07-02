package com.schola.domain.user;


public class UserService {

    private UserGateway userGateway;

    public void doAuth(String email , String password){
         userGateway.autoLogin(email, password);
    }

}
