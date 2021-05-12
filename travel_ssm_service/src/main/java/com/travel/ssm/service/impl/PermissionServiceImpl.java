package com.travel.ssm.service.impl;

import com.travel.ssm.dao.IPermissionDao;
import com.travel.ssm.domain.Permission;
import com.travel.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public void deleteById(String id) {
        //从role_permission表中删除
        permissionDao.deleteFromRole_PermissionById(id);
        //从permission表中删除
        permissionDao.deleteById(id);
    }
}
