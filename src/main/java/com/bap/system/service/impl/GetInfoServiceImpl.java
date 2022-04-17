package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import org.springframework.stereotype.Service;
import com.bap.system.dao.GetInfoEnRepository;
import com.bap.system.dao.GetInfoPeRepository;
import com.bap.system.entity.InformationEnterpriseEmployees;
import com.bap.system.entity.informationPersonal;
import com.bap.system.service.GetInfoService;
import com.bap.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GetInfoServiceImpl implements GetInfoService {
    @Resource
    GetInfoEnRepository getInfoEnRepository;

    @Resource
    GetInfoPeRepository getInfoPeRepository;

    @Override
    public Result getByIdEn(int data) {
        List<InformationEnterpriseEmployees> list = getInfoEnRepository.getById(data);
        return new Result(list);
    }
    @Override
    public Result getByIdPe(int data) {
        List<informationPersonal> list = getInfoPeRepository.getById(data);
        return new Result(list);
    }
}
