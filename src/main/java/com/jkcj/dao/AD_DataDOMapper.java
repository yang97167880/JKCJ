package com.jkcj.dao;

import com.jkcj.DO.AD_DataDO;

public interface AD_DataDOMapper {
    int insert(AD_DataDO record);

    int insertSelective(AD_DataDO record);
}