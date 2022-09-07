package com.kathesama.restfulapi.model.request;

import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "builder")
@NoArgsConstructor
@Builder(toBuilder = true, builderClassName = "Builder")
public class RoleRequestModel {
    @NotNull(message = "role is required")
    @NotEmpty(message = "role shouldn't be empty")
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 50, message = "{validation.name.size.too_long}")
    private String role;

    @NotNull
    private Boolean isActive = false;
}
