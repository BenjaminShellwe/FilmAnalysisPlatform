package com.bap.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * The interface SeniorVacancy coming mapper.
 */
@Mapper
public interface VacancyMapper {

    /**
     * Update by aid.
     *
     * @param aid the aid
     * @param i   the
     */
    @Update("update senior_vacancy_create set verify = #{i} where affairID = #{aid}")
    public void updateByAid(String aid, int i);

    /**
     * Delete by aid.
     *
     * @param aid the aid
     */
    @Delete("delete from senior_vacancy_create where affairID = #{aid}")
    public void deleteByAid(String aid);
}
