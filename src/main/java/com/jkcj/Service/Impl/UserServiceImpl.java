package com.jkcj.Service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jkcj.DO.UserDO;
import com.jkcj.Error.BusinessException;
import com.jkcj.Error.EmBusinessErr;
import com.jkcj.Response.RTStr;
import com.jkcj.Service.UserService;
import com.jkcj.Utils.MD5Util;
import com.jkcj.Utils.MySessionUtil;
import com.jkcj.Utils.PageUtil;
import com.jkcj.VO.UserVO;
import com.jkcj.dao.UserDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public String userAdd(String username,String password,String tel) throws  BusinessException{
        try{
            String MD5PSD = MD5Util.getMD5(password);
            int flag = userDOMapper.userAdd(username,MD5PSD,tel);
            return flag==1? RTStr.SUCCESS:RTStr.ERROR;
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.UNKNOWN_ERROR);
        }
    }

    @Override
    public UserVO getUserInfo() throws BusinessException{
        try {
            int uid = (Integer) MySessionUtil.getSession().getAttribute(MySessionUtil.USER_ACCOUNT);
            if(uid == 0) return null;
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

    @Override
    public Map getUserList(Integer pageNo, Integer pageSize) throws BusinessException{
        try{
            Page page = PageHelper.startPage(pageNo, pageSize);
            List<UserVO> userVOList = userDOMapper.getUserList();
            return PageUtil.getListWithPageInfo(userVOList,page);
        } catch (Exception e){
            throw new BusinessException(EmBusinessErr.USER_LIST_GET_ERROR);
        }
    }

    @Override
    public String userLogin(String username, String password) throws BusinessException{
        try{
            UserDO userDO = userDOMapper.userLogin(username);
            if(userDO == null){
                return RTStr.ERROR;
            }else{
                if(userDO.getPassword().equals(MD5Util.getMD5(password)) && userDO.getStatus() == 1){
                    MySessionUtil.getSession().setAttribute(MySessionUtil.USER_ACCOUNT, userDO.getUid());
                    return RTStr.SUCCESS;
                }else{
                    return RTStr.ERROR;
                }
            }
        } catch (Exception e){
            throw new BusinessException(EmBusinessErr.USER_LOGIN_ERROR);
        }
    }

    @Override
    public String deleteAdmin(Integer uid) throws BusinessException{
        try{
            int flag = userDOMapper.deleteByPrimaryKey(uid);
            return flag==1? RTStr.SUCCESS:RTStr.ERROR;
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.USER_DELETE_ERROR);
        }
    }

    @Override
    public String banAdmin(Integer status,Integer uid) throws BusinessException{
        try{
            int flag = userDOMapper.banUser(status ,uid);
            return flag==1? RTStr.SUCCESS:RTStr.ERROR;
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.UNKNOWN_ERROR);
        }
    }

    @Override
    public String updateUser (String username ,String tel ,Integer uid)throws BusinessException{
        try {
            UserDO userDO = userDOMapper.userLogin(username);
            if(userDO == null){
                int flag = userDOMapper.updateUser(username,tel,uid);
                return flag==1? RTStr.SUCCESS:RTStr.ERROR;
            }
            return RTStr.ERROR;
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.UNKNOWN_ERROR);
        }
    }
}
