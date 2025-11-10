package com.warehouseManagement.wm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateUserRequest {
    private String no;
    private String name;
    private String password;
    private int age;
    private int sex;
    private String phone;
    private int roleId;
    private String isValid;
}
