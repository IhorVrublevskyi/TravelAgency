package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.RoleDao;
import org.lv326java.two.travelagency.dto.RoleDto;
import org.lv326java.two.travelagency.entities.Role;

import java.util.LinkedList;
import java.util.List;

public class RoleService {

    private RoleDao roleDao;

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public RoleService() {
        this.roleDao = new RoleDao();
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<RoleDto> getAll() {
        List<RoleDto> roles = new LinkedList<>();
        for (Role role : roleDao.getAll()) {
            roles.add(new RoleDto(role.getId().toString(), role.getName()));
        }
        return roles;
    }
}
