package com.example.demodbs.Controller;

import com.example.demodbs.Models.User;
import com.example.demodbs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers()  throws SQLException // this api is for getting all the user in list
    {
      return userService.getUsers();
    }

    @GetMapping("/user")             //this api is for the getting the user on the basis of id;
    public User getUserById(@RequestParam("id") int id) throws SQLException
    {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestParam("user") User user) throws SQLException
    {
        userService.insertUser(user);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam("id")int id) throws SQLException
    {
       userService.deleteUser(id);
    }





}
