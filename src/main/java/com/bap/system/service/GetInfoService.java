package com.bap.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import com.bap.util.Result;

/**
 * The interface Get info service.
 */
public interface GetInfoService {
    /**
     * Gets by id en.
     *
     * @param data the data
     * @return the by id en
     */
    Result getByIdEn(int data);

    /**
     * Gets by id pe.
     *
     * @param data the data
     * @return the by id pe
     */
    Result getByIdPe(int data);
}
