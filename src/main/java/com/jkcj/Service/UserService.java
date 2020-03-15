package com.jkcj.Service;

import com.jkcj.DO.UserDO;
import com.jkcj.Error.BusinessException;
import com.jkcj.VO.UserVO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {

    UserVO getUserInfo() throws BusinessException;

    UserDO selectByPrimaryKey(Integer uid) throws BusinessException;

    Map getUserList(Integer pageNo, Integer pageSize) throws BusinessException;

    String userLogin(String username,String password) throws BusinessException;

    String userAdd(String username,String password,String tel) throws  BusinessException;

    String deleteAdmin(Integer uid) throws BusinessException;

    String banAdmin(Integer status,Integer uid) throws BusinessException;

    String updateUser (String username ,String tel ,Integer uid)throws BusinessException;
}
