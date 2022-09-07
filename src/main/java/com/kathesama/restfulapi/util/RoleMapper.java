package com.kathesama.restfulapi.util;

import com.kathesama.restfulapi.model.dto.RoleDTO;
import com.kathesama.restfulapi.model.entity.RoleEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleFromDto(RoleDTO roleDto, @MappingTarget RoleEntity entity);
}
