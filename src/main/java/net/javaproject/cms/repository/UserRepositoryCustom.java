package net.javaproject.cms.repository;

public interface UserRepositoryCustom {
    Boolean verifyUserLogin(String email, String password);
}
