package com.warehouseManagement.wm.controller;

import com.warehouseManagement.wm.entity.User;
import com.warehouseManagement.wm.model.CreateUserRequest;
import com.warehouseManagement.wm.model.ModifyUserRequest;
import com.warehouseManagement.wm.model.SearchUserRequest;
import com.warehouseManagement.wm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(){
        return "Welcome to userController";
    }

    @GetMapping("/userList")
    public List<User> userList(){
        return userService.userList();
    }

    @PostMapping("/save")
    public User save (@RequestBody CreateUserRequest createUserRequest){
        return userService.save(createUserRequest);
    }

    @PostMapping("/modify")
    public User modify (@RequestBody ModifyUserRequest modifyUserRequest){
        return userService.modify(modifyUserRequest);
    }

    @PostMapping("/saveOrModify")
    public User saveOrModify (@RequestBody ModifyUserRequest modifyUserRequest){
        return userService.saveOrModify(modifyUserRequest);
    }

    @DeleteMapping("/delete")
    public boolean delete (Integer id){
        return userService.delete(id);
    }

    @PostMapping("/searchUser")
    public List<User> searchUser (@RequestBody SearchUserRequest searchUserRequest){
        return userService.searchUser(searchUserRequest);
    }
}
