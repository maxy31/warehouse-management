package com.warehouseManagement.wm.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModifyUserRequest {
    private int id;
    private String no;
    private String name;
    private String password;
    private int age;
    private int sex;
    private String phone;
    private int roleId;
    private String isValid;
}
