package com.schola.domain.user;

public interface UserGateway {
    String findUserbyEmail();

    User autoLogin(String username, String password);
}
