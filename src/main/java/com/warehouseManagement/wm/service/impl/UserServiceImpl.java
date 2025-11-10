package com.warehouseManagement.wm.service.impl;

import com.warehouseManagement.wm.entity.User;
import com.warehouseManagement.wm.model.CreateUserRequest;
import com.warehouseManagement.wm.model.ModifyUserRequest;
import com.warehouseManagement.wm.model.SearchUserRequest;
import com.warehouseManagement.wm.repository.UserRepository;
import com.warehouseManagement.wm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> userList(){
        return userRepository.findAll();
    }

    @Override
    public User save(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setNo(createUserRequest.getNo());
        user.setName(createUserRequest.getName());
        user.setPassword(createUserRequest.getPassword());
        user.setAge(createUserRequest.getAge());
        user.setPhone(createUserRequest.getPhone());
        user.setIsValid(createUserRequest.getIsValid());
        user.setSex(createUserRequest.getSex());
        user.setRoleId(createUserRequest.getRoleId());
        return userRepository.save(user);
    }

    @Override
    public User modify(ModifyUserRequest modifyUserRequest) {
        User userModified = new User();
        Optional<User> userTarget = userRepository.findByNo(modifyUserRequest.getNo());
        
        if(userTarget.isPresent()){
            userModified = userTarget.get();
            userModified.setNo(modifyUserRequest.getNo());
            userModified.setName(modifyUserRequest.getName());
            userModified.setPassword(modifyUserRequest.getPassword());
            userModified.setAge(modifyUserRequest.getAge());
            userModified.setPhone(modifyUserRequest.getPhone());
            userModified.setIsValid(modifyUserRequest.getIsValid());
            userModified.setSex(modifyUserRequest.getSex());
            userModified.setRoleId(modifyUserRequest.getRoleId());
        }
        return userRepository.save(userModified);
    }

    @Override
    public User saveOrModify(ModifyUserRequest modifyUserRequest) {
        Optional<User> userTarget = userRepository.findByNo(modifyUserRequest.getNo());
        User userResult = new User();
        if(userTarget.isPresent()){
            userResult = modify(modifyUserRequest);
        } else {
            CreateUserRequest createUserRequest = new CreateUserRequest();
            createUserRequest.setNo(modifyUserRequest.getNo());
            createUserRequest.setName(modifyUserRequest.getName());
            createUserRequest.setPassword(modifyUserRequest.getPassword());
            createUserRequest.setAge(modifyUserRequest.getAge());
            createUserRequest.setPhone(modifyUserRequest.getPhone());
            createUserRequest.setSex(modifyUserRequest.getSex());
            createUserRequest.setRoleId(modifyUserRequest.getRoleId());
            createUserRequest.setIsValid(modifyUserRequest.getIsValid());
            userResult = save(createUserRequest);
        }
        return userResult;
    }

    @Override
    public Boolean delete(Integer id){
        boolean result = false;
        Optional<User> userTarget = userRepository.findById(id);

        if(userTarget.isPresent()){
            userRepository.delete(userTarget.get());
            result = true;
        }
        return result;
    }

    @Override
    public List<User> searchUser(SearchUserRequest searchUserRequest) {
        return userRepository.searchUser(searchUserRequest.getNo(),searchUserRequest.getName(),
                searchUserRequest.getAge(), searchUserRequest.getSex(),searchUserRequest.getPhone(),
                searchUserRequest.getRoleId(),searchUserRequest.getIsValid());
    }
}
