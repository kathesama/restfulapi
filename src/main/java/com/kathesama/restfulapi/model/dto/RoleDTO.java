package com.kathesama.restfulapi.model.dto;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor(staticName = "builder")
@NoArgsConstructor
@ToString
public class RoleDTO {
    private String id;
    private String role;
    private Boolean isActive;
    private Date createdAt;
    private Date updatedAt;
}
