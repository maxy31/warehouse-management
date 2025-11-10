package com.warehouseManagement.wm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchUserRequest {
    private String no;
    private String name;
    private Integer age;
    private Integer sex;
    private String phone;
    private Integer roleId;
    private String isValid;
}
