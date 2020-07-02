package com.schola.domain.user;

public interface UserGateway {
    User findUserbyEmail(String email);

    void autoLogin(String username, String password);
}
