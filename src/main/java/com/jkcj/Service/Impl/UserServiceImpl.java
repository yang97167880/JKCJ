package com.jkcj.Service.Impl;

import com.jkcj.DO.UserDO;
import com.jkcj.Error.BusinessException;
import com.jkcj.Error.EmBusinessErr;
import com.jkcj.Service.UserService;
import com.jkcj.Utils.MySessionUtil;
import com.jkcj.VO.UserVO;
import com.jkcj.dao.UserDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:Xhy
 * @Date:2020/2/17 20:08
 * @Description:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDOMapper userDOMapper;

    @Override
    public UserVO getUserInfo(Integer uid) throws BusinessException{
        try {
            if (uid == null) {
                uid = (Integer) MySessionUtil.getSession().getAttribute(MySessionUtil.USER_ACCOUNT);
                if (uid == null) return null;
            }
            UserVO userVO = userDOMapper.getUserInfo(uid);
            return userVO;
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.UNKNOWN_ERROR);
        }
    }

    @Override
    public UserDO selectByPrimaryKey(Integer uid) throws BusinessException{
        try{
            UserDO userDO = userDOMapper.selectByPrimaryKey(uid);
            return userDO;
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.UNKNOWN_ERROR);
        }
    }

}
