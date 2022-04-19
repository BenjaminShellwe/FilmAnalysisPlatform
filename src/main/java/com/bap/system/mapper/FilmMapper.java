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

@Mapper
@Repository
public interface FilmMapper extends BaseMapper<FilmData> {

    @Select("select count(*) from data1")
    String count();
}
