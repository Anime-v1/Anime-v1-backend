package com.example.animev1backend.service;

import com.example.animev1backend.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role createRole(Role role);
    Role updateRole(Long id,Role role);
    void deleteRole(Long id);

}
