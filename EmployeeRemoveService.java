package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.AdjustSalaryMapper;
import org.javaboy.vhr.mapper.DepartmentMapper;
import org.javaboy.vhr.mapper.EmployeeremoveMapper;
import org.javaboy.vhr.mapper.PositionMapper;
import org.javaboy.vhr.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
@Service
public class EmployeeRemoveService {
    @Autowired
    EmployeeremoveMapper employeeremoveMapper;
    public List<Employeeremove> getAllEmployeeRemove() {
        return employeeremoveMapper.getAllEmployeeRemove();
    }

    public RespPageBean getAllEmployeeRemoveByPage(Integer page, Integer size, Employeeremove employeeremove, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employeeremove> data = employeeremoveMapper.getAllEmployeeRemoveByPage(page, size, employeeremove, beginDateScope);
        Long total = employeeremoveMapper.getTotal(employeeremove, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }
    /**添加
     */
    public Integer addEmployeeRemove(Employeeremove employeeRemove) {
        return employeeremoveMapper.insert(employeeRemove);
    }
    /**删除
     */
    public int deleteEmployeeRemoveByEid(Integer id) {
        return employeeremoveMapper.deleteByPrimaryKey(id);
    }
    /**更新
     */
    public int updateEmployeeRemove(Employeeremove employeeremove) {
        return employeeremoveMapper.updateByPrimaryKeySelective(employeeremove);
    }
}

