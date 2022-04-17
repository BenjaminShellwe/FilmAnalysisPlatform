package com.bap.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.util.Result;
import com.bap.system.entity.SeniorVacancyCreate;

/**
 * The interface SeniorVacancy coming service.
 */
public interface VacancyComingService {
    /**
     * Query all result.
     *
     * @return the result
     */
    Result queryAll();

    /**
     * Update all result.
     *
     * @param seniorVacancyCreate the vacancy coming
     * @return the result
     */
    Result updateAll(SeniorVacancyCreate seniorVacancyCreate);
}
