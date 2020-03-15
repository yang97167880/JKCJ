package com.jkcj.Service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jkcj.DO.RoleDO;
import com.jkcj.DO.UserDO;
import com.jkcj.Error.BusinessException;
import com.jkcj.Error.EmBusinessErr;
import com.jkcj.Response.RTStr;
import com.jkcj.Service.RoleService;
import com.jkcj.Utils.PageUtil;
import com.jkcj.dao.RoleDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther:Xhy
 * @Date:2020/2/24 15:57
 * @Description:
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDOMapper roleDOMapper;

    @Override
    public Map getRoleList(Integer pageNo, Integer pageSize) throws BusinessException{
        try{
            Page page = PageHelper.startPage(pageNo,pageSize);
            List<RoleDO> roleDOList = roleDOMapper.getRoleList();
            return PageUtil.getListWithPageInfo(roleDOList,page);
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.ROLE_LIST_GET_ERROR);
        }
    }

    @Override
    public String deleteRole(Integer role_id) throws BusinessException{
        try{
            int flag = roleDOMapper.deleteByPrimaryKey(role_id);
            return flag==1? RTStr.SUCCESS:RTStr.ERROR;
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.ROLE_DELETE_ERROR);
        }
    }

    @Override
    public  String banRole(Integer status , Integer rid) throws BusinessException{
        try{
            int flag = roleDOMapper.banRole(status ,rid);
            return flag==1? RTStr.SUCCESS:RTStr.ERROR;
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.UNKNOWN_ERROR);
        }
    }

    @Override
    public String updateRole(String name ,String detail,String title , Integer rid) throws BusinessException{
        try{
            int flag = roleDOMapper.updateRole(name,detail,title,rid);
            return flag==1? RTStr.SUCCESS:RTStr.ERROR;
        }catch (Exception e){
            throw new BusinessException(EmBusinessErr.UNKNOWN_ERROR);
        }
    }
}
