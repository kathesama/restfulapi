package com.kathesama.restfulapi.service.implementation;

import com.kathesama.restfulapi.exception.GenericCollectionException;
import com.kathesama.restfulapi.model.dto.RoleDTO;
import com.kathesama.restfulapi.model.entity.RoleEntity;
import com.kathesama.restfulapi.repository.RoleRepository;
import com.kathesama.restfulapi.service.RoleServiceInterface;
import com.kathesama.restfulapi.util.RoleMapper;
import com.kathesama.restfulapi.util.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleServiceInterface {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper mapper;

    @Override
    public List<RoleDTO> getAllRoles() throws ConstraintViolationException, GenericCollectionException {
        return new ModelMapper().map(roleRepository.findAll(), new TypeToken<List<RoleDTO>>() {}.getType());
    }

    @Override
    public RoleDTO getOneRole(String id) throws ConstraintViolationException, GenericCollectionException {
        return null;
    }

    @Override
    public RoleDTO createRole(RoleDTO role) throws ConstraintViolationException, GenericCollectionException {
        RoleEntity roleEntity = new RoleEntity();

        BeanUtils.copyProperties(role, roleEntity);

        roleEntity = roleRepository.save(roleEntity);
        BeanUtils.copyProperties(roleEntity, role);

        return role;
    }

    @Override
    public RoleDTO updateRole(String id, RoleDTO roleDto) throws GenericCollectionException {
        Optional<RoleEntity> actualRole = roleRepository.findById(id);
        if (actualRole.isEmpty()){
            throw new GenericCollectionException(GenericCollectionException.NotFound(id));
        }
        RoleEntity roleRegister = actualRole.get();
        mapper.updateRoleFromDto(roleDto, roleRegister);

        return new ModelMapper().map(roleRepository.save(roleRegister), new TypeToken<RoleDTO>() {}.getType());
    }

    @Override
    public RoleDTO deleteRole(String id) throws ConstraintViolationException, GenericCollectionException {
        Optional<RoleEntity> actualRole = roleRepository.findById(id);
        if (actualRole.isEmpty()){
            throw new GenericCollectionException(GenericCollectionException.NotFound(id));
        }

        RoleEntity roleRegister = actualRole.get();
        roleRegister.setIsActive(false);
        return new ModelMapper().map(roleRepository.save(roleRegister), new TypeToken<RoleDTO>() {}.getType());
    }
}
