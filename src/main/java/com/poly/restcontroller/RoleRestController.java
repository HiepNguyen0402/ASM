package com.poly.restcontroller;

import com.poly.entity.Role;
import com.poly.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RoleRestController {
    @Autowired
    RoleService roleService;

    @GetMapping("/rest/roles")
    public List<Role> getAll(){
        return roleService.findAll();
    }
}
