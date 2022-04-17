package com.bap.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import com.bap.system.entity.DictionaryGlobal;
import com.bap.util.Result;

/**
 * The interface Global dic service.
 */
public interface GlobalDicService {
    /**
     * Query all result.
     *
     * @return the result
     */
    Result queryAll();

    /**
     * Update global dic.
     *
     * @param dictionaryGlobal the dictionary
     */
    void updateGlobalDic(DictionaryGlobal dictionaryGlobal);
}
