package com.xiaochen.springboot.demo.beans;


import lombok.Data;

/**
 * @author shkstart
 * @create 04-01 16:10
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private int status;
}
