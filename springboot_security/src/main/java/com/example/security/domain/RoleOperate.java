package com.example.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleOperate {
    private Integer id;
    private Integer roleId;
    private Integer operateId;


}