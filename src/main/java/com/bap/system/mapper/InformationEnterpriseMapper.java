package com.bap.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.alibaba.fastjson.JSONObject;
import com.bap.system.entity.InformationEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * The interface Enterprise mapper.
 */
@Mapper
public interface InformationEnterpriseMapper {
    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Select("select * from information_enterprise where id = #{'id'}")
    public List<InformationEnterprise> getById(Object id);

    /**
     * Unite table list.
     *
     * @return the list
     */
    @Select("select v.affairID, v.position, v.positionStatus, v.enterpriseID, v.department, v.departmentID, v.description, v.createdTime, v.salary, v.requirement, v.deadline, v.type," +
            " d.name, d.enterprise, d.UIDD, d.director, d.phoneD, d.phoneM, d.UIDM, d.manager, d.departmentStatus" +
            " from senior_vacancy v inner join information_enterprise_department d on v.departmentID = d.departmentID")
    public List<Map<String, JSONObject>> uniteTable();
}
