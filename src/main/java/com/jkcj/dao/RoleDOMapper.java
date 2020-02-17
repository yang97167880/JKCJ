package com.jkcj.dao;

import com.jkcj.DO.RoleDO;

public interface RoleDOMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleDO record);

    int insertSelective(RoleDO record);

    RoleDO selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);
}