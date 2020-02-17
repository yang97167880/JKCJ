package com.jkcj.Service;

import com.jkcj.DO.UserDO;
import com.jkcj.Error.BusinessException;
import com.jkcj.VO.UserVO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserVO getUserInfo(Integer uid) throws BusinessException;

    UserDO selectByPrimaryKey(Integer uid) throws BusinessException;
}
