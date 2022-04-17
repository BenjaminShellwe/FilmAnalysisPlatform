package com.bap.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import org.springframework.stereotype.Service;
import com.bap.system.dao.GlobalDicRepository;
import com.bap.system.entity.DictionaryGlobal;
import com.bap.system.service.GlobalDicService;
import com.bap.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GlobalDicServiceImpl implements GlobalDicService {
    @Resource
    GlobalDicRepository globalDicRepository;

    @Override
    public Result queryAll() {
        List<DictionaryGlobal> list = globalDicRepository.findAll();
        return new Result(list);
    }

    @Override
    public void updateGlobalDic(DictionaryGlobal dictionaryGlobal) {
        globalDicRepository.save(dictionaryGlobal);
        new Result(200, "Success");
    }
}
