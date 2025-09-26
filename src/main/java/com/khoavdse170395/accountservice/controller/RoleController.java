package com.khoavdse170395.accountservice.controller;

import com.khoavdse170395.accountservice.model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    public ResponseEntity<List<Role>> getRoleByName() {
        return ResponseEntity.ok(null);
    }
}
