package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import org.springframework.stereotype.Service;
import com.bap.system.dao.VacancyRepository;
import com.bap.system.entity.SeniorVacancy;
import com.bap.system.service.VacancyService;
import com.bap.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Resource
    VacancyRepository vacancyRepository;

    @Override
    public Result queryAll() {
        List<SeniorVacancy> list = vacancyRepository.findAll();
        return new Result(list);
    }

    @Override
    public Result publish(SeniorVacancy data) {
        vacancyRepository.save(data);
        return new Result(200, "Success");
    }

    @Override
    public void update(SeniorVacancy data) {
        vacancyRepository.save(data);
    }
}
