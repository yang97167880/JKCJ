package com.jkcj.dao;

import com.jkcj.DO.Rel_DataDO;

public interface Rel_DataDOMapper {
    int insert(Rel_DataDO record);

    int insertSelective(Rel_DataDO record);
}