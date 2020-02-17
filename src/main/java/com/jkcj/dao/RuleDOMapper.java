package com.jkcj.dao;

import com.jkcj.DO.RuleDO;

public interface RuleDOMapper {
    int deleteByPrimaryKey(Integer ruleId);

    int insert(RuleDO record);

    int insertSelective(RuleDO record);

    RuleDO selectByPrimaryKey(Integer ruleId);

    int updateByPrimaryKeySelective(RuleDO record);

    int updateByPrimaryKey(RuleDO record);
}