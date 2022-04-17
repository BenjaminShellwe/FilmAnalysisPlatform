package com.bap.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.entity.SeniorVacancy;
import com.bap.util.Result;

/**
 * The interface SeniorVacancy service.
 */
public interface VacancyService {
    /**
     * Query all result.
     *
     * @return the result
     */
    Result queryAll();

    /**
     * Publish result.
     *
     * @param data the data
     * @return the result
     */
    Result publish(SeniorVacancy data);

    /**
     * Update.
     *
     * @param data the data
     */
    void update(SeniorVacancy data);
}
