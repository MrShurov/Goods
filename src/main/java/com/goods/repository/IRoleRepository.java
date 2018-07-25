package com.goods.repository;

import com.goods.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<Role, Integer> {
    Role getRoleByRole(String role);
}
