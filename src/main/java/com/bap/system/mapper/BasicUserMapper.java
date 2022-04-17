package com.bap.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bap.system.dto.input.UserQueryPara;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.bap.system.entity.BasicUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@Repository
public interface BasicUserMapper extends BaseMapper<BasicUser> {

    @Select("select userName from basic_user where userName = #{'userName'}")
    String selectUserName(String userName);

    @Select("select userPassword from basic_user where userName = #{'userName'}")
    String selectUserPassword(String userName);

    @Select("select id from basic_user where userName = #{'userName'}")
    int check(String userName);

    @Insert("insert into basic_user(userName, userPassword) values(#{'userName'}, #{'userPassword'})")
    void addUser(String userName, String userPassword);

    @Update("update basic_user set userPassword = #{psw} where id = #{id} and userName = #{userName}")
    void updatePsw(Object id, Object psw, Object userName);

    @Select("select id, userRealName from basic_user where enterpriseID = #{'enterpriseID'}")
    List<BasicUser> queryEID(String enterpriseID);

    @Select("select enterpriseID from basic_user where id = #{'id'}")
    public List<BasicUser> getEID(String id);

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<BasicUser> selectUsers(Pagination page, @Param("filter") UserQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<BasicUser> selectUsers(@Param("filter") UserQueryPara filter);


    /**
     * 通过token查找用户信息
     *
     * @param token:
     * @return: top.shellwe.bip.system.entity.User
     */
    BasicUser getUserInfoByToken(@Param("token") String token);


    /**
     * 通过角色ID查询用户集合
     *
     * @param roleId:
     * @return: java.util.List<Role>
     */
    List<BasicUser> selectUserByRoleId(@Param("roleId") Integer roleId);

    /**
     * 通过账号查找用户信息
     *
     * @param username:
     * @return: top.shellwe.bip.system.entity.User
     */
    BasicUser selectUserByUsername(@Param("username") String username);
}
