package com.kathesama.restfulapi.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoleResponseModel {
    private String id;
    private String role;
    private Boolean isActive;
}
