package com.jkcj.Service;

import com.jkcj.Error.BusinessException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface RoleService {

    Map getRoleList(Integer pageNo, Integer pageSize) throws BusinessException;

    String deleteRole(Integer role_id) throws BusinessException;

    String banRole(Integer status , Integer rid) throws BusinessException;

    String updateRole(String name ,String detail,String title , Integer rid) throws BusinessException;
}
