package ru.vakulchuk.springBootCRUD.service;

import ru.vakulchuk.springBootCRUD.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User userInfo(long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
}
