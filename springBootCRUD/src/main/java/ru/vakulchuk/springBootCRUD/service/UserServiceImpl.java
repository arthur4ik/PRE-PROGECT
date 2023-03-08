package ru.vakulchuk.springBootCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vakulchuk.springBootCRUD.models.User;
import ru.vakulchuk.springBootCRUD.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository usersRepository) {
        this.userRepository = usersRepository;
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User userInfo(long id){
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public void updateUser(User user){
        userRepository.save(user);
    }
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
