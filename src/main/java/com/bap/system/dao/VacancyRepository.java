package com.bap.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.entity.SeniorVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface SeniorVacancy repository.
 */
@Repository(value = "vacancyService")
public interface VacancyRepository extends JpaRepository<SeniorVacancy,Integer> {
}
