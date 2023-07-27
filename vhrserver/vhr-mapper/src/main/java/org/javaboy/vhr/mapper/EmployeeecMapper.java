package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.Employeeec;

import java.util.Date;
import java.util.List;

public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);

    /**
     * 以分页的形式向数据库查询员工的奖惩信息
     *
     * @param page
     * @param size
     * @param employeeec
     * @param beginDateScope
     * @return List<Employeeec>
     */
    List<Employeeec> getEmployeeecByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("empec") Employeeec employeeec, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("empec") Employeeec employeeec, @Param("beginDateScope") Date[] beginDateScope);


}