package com.travel.ssm.service;

import com.travel.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll();

    void save(Permission permission);

    void deleteById(String id);
}
