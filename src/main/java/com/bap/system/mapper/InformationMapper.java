package com.bap.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.entity.InformationEnterpriseEmployees;
import com.bap.system.entity.informationPersonal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The interface Get info mapper.
 */
@Mapper
public interface InformationMapper {

    /**
     * Gets by id en.
     *
     * @param userID the user id
     * @return the by id en
     */
    @Select("select * from information_enterprise_employees where userID = #{'userID'}")
    public List<InformationEnterpriseEmployees> getByIdEn(Object userID);

    /**
     * Gets by eid.
     *
     * @param enterpriseID the enterprise id
     * @return the by eid
     */
    @Select("select * from information_enterprise_employees where enterpriseID = #{enterpriseID}")
    public List<InformationEnterpriseEmployees> getByEID(Object enterpriseID);

    /**
     * Gets by id pe.
     *
     * @param userID the user id
     * @return the by id pe
     */
    @Select("select * from information_personal where userID = #{'userID'}")
    public List<informationPersonal> getByIdPe(Object userID);

}
