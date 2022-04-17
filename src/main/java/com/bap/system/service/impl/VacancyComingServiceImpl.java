package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import org.springframework.stereotype.Service;
import com.bap.system.dao.VacancyComingRepository;
import com.bap.system.entity.SeniorVacancyCreate;
import com.bap.system.service.VacancyComingService;
import com.bap.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VacancyComingServiceImpl implements VacancyComingService {

    @Resource
    VacancyComingRepository vacancyComingRepository;

    @Override
    public Result queryAll() {
        List<SeniorVacancyCreate> list = vacancyComingRepository.findAll();
        return new Result(list);
    }

    @Override
    public Result updateAll(SeniorVacancyCreate seniorVacancyCreate) {
        vacancyComingRepository.save(seniorVacancyCreate);
        return new Result(200, "Success");
    }
}
