package com.jkcj.dao;

import com.jkcj.DO.UserDO;
import com.jkcj.VO.UserVO;

public interface UserDOMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    UserVO getUserInfo(Integer uid);
}