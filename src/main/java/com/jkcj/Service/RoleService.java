package com.jkcj.Service;

import com.jkcj.Error.BusinessException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface RoleService {

    Map getRoleList(Integer pageNo, Integer pageSize) throws BusinessException;
}
