package com.kathesama.restfulapi.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserDetailsRequestModel {

    private Boolean isActive;
    private Boolean isGoogle;
    private String userId;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Double age;
    private String image;
    private String role;
    private Date createdAt;
    private Date updatedAt;
}
