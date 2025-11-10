package com.warehouseManagement.wm.service;

import com.warehouseManagement.wm.entity.User;
import com.warehouseManagement.wm.model.CreateUserRequest;
import com.warehouseManagement.wm.model.ModifyUserRequest;
import com.warehouseManagement.wm.model.SearchUserRequest;

import java.util.List;

public interface UserService {
    List<User> userList();
    User save (CreateUserRequest createUserRequest);
    User modify (ModifyUserRequest modifyUserRequest);
    User saveOrModify (ModifyUserRequest modifyUserRequest);
    Boolean delete (Integer id);
    List<User> searchUser(SearchUserRequest searchUserRequest);
}
