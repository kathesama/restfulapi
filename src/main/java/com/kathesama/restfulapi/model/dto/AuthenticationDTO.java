package com.kathesama.restfulapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "authentication")
public class AuthenticationDTO {
    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    private String usuario;

    @NotNull
    private String clave;

    private Date createdAt;
    private Date updatedAt;
}
