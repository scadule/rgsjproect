package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Employeeremove;

import java.util.Date;
import java.util.List;

public interface EmployeeremoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeremove record);

    int insertSelective(Employeeremove record);

    Employeeremove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeremove record);

    int updateByPrimaryKey(Employeeremove record);

    List<Employeeremove> getAllEmployeeRemoveByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employeeremove employeeremove, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") Employeeremove employeeremove,@Param("beginDateScope") Date[] beginDateScope);
}