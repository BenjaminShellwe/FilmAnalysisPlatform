package com.bap.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bap.system.entity.BasicRole;

/**
 * The interface Role repository.
 */
@Repository(value = "RoleService")
public interface RoleRepository extends JpaRepository<BasicRole,Integer> {

}
