package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> getALLUsers();
    User userInfo(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
