package com.example.demo.service;
import com.example.demo.models.User;
import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(int theId);

    public void save(User theUser);

}
