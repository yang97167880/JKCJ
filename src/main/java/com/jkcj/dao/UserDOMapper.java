package com.jkcj.dao;

import com.jkcj.DO.UserDO;
import com.jkcj.VO.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserDOMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    int userAdd(@Param("username") String username,@Param("password") String password,@Param("tel") String tel);

    UserDO userLogin(String username);

    UserVO getUserInfo(Integer uid);

    List<UserVO> getUserList();
}