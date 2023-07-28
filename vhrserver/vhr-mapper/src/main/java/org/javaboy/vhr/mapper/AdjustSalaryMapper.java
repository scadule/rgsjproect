package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.AdjustSalary;

import java.util.Date;
import java.util.List;

public interface AdjustSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);

    AdjustSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdjustSalary record);

    int updateByPrimaryKey(AdjustSalary record);

    List<AdjustSalary> getAdjustSalaryByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") AdjustSalary adjustSalary, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") AdjustSalary adjustSalary, @Param("beginDateScope") Date[] beginDateScope);
}