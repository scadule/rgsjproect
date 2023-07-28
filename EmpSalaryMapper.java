package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.EmpSalary;

import java.util.List;

public interface EmpSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmpSalary record);

    int insertSelective(EmpSalary record);

    EmpSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpSalary record);

    int updateByPrimaryKey(EmpSalary record);

    List<EmpSalary> selectByEid(Integer id);
}