package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.Employeetrain;

import java.util.Date;
import java.util.List;

public interface EmployeetrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeetrain record);

    int insertSelective(Employeetrain record);

    Employeetrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeetrain record);

    int updateByPrimaryKey(Employeetrain record);

    /**
     * 以分页的形式向数据库查询员工的培训信息
     *
     * @param page
     * @param size
     * @param employeetrain
     * @param beginDateScope
     * @return List<Employeeec>
     */
    List<Employeetrain> getEmployeetrainByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emptrain") Employeetrain employeetrain, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emptrain") Employeetrain employeetrain, @Param("beginDateScope") Date[] beginDateScope);
}