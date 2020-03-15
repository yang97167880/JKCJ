package com.jkcj.dao;

import com.jkcj.DO.RoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDOMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleDO record);

    int insertSelective(RoleDO record);

    RoleDO selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);

    List<RoleDO> getRoleList();

    int banRole(@Param("status")Integer status , @Param("rid")Integer rid);

    int updateRole(@Param("name")String name , @Param("detail")String detail,@Param("title")String title , @Param("rid")Integer rid);
}