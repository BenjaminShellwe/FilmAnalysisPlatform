package com.bap.system.mapper;
/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/19 9:54:5
 */


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bap.system.entity.FilmData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface FilmMapper extends BaseMapper<FilmData> {

    @Select("select count(*) from data1")
    String count();
    @Select("SELECT `release`, COUNT(*) AS total " +
            "FROM data1 " +
            "GROUP BY data1.`release` " +
            "HAVING COUNT(1) >= 1 " +
            "ORDER BY `release` ASC")
    List<Map<String, Integer>> yearsCount();

    @Select("SELECT score, f1, title, director FROM data1 ORDER BY RAND() LIMIT 1")
    List<Map<String, Integer>> randomFilm();

    @Select("SELECT data1.budget, data1.boxoffice, data1.title, data1.popularity, data1.duration, data1.evaluators, data1.score, data1.release " +
            "FROM data1 " +
            "WHERE data1.f1 BETWEEN #{i} AND #{j} " +
            "GROUP BY  data1.f1")
    List<Map<String, Integer>> budgetFilm(int i, int j);
}
