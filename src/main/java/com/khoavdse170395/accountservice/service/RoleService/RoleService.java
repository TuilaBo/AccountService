package com.khoavdse170395.accountservice.service.RoleService;

import com.khoavdse170395.accountservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RoleService extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}
