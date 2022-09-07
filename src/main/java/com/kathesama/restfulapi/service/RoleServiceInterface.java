package com.kathesama.restfulapi.service;

import com.kathesama.restfulapi.exception.GenericCollectionException;
import com.kathesama.restfulapi.model.dto.RoleDTO;
import com.kathesama.restfulapi.model.request.RoleRequestModel;
import com.kathesama.restfulapi.model.response.RoleResponseModel;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface RoleServiceInterface {
    public List<RoleDTO> getAllRoles() throws ConstraintViolationException, GenericCollectionException;
    public RoleDTO getOneRole(String id) throws ConstraintViolationException, GenericCollectionException;
    public RoleDTO createRole(RoleDTO todo) throws ConstraintViolationException, GenericCollectionException;
    public RoleDTO updateRole(String id, RoleDTO todo) throws ConstraintViolationException, GenericCollectionException;
    public RoleDTO deleteRole(String id) throws ConstraintViolationException, GenericCollectionException;
}
