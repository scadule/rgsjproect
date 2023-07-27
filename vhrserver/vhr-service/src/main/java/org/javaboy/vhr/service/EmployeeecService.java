package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeecMapper;
import org.javaboy.vhr.model.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeecService {

    @Autowired
    EmployeeecMapper employeeecMapper;

    /**
     * 以分页的形式获取员工的奖惩信息
     *
     * @param page
     * @param size
     * @param employeeec
     * @param beginDateScope
     * @return
     */
    public RespPageBean getEmployeeecByPage(Integer page, Integer size, Employeeec employeeec, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employeeec> data = employeeecMapper.getEmployeeecByPage(page, size, employeeec, beginDateScope);
        Long total = employeeecMapper.getTotal(employeeec, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    /**
     * 添加员工奖惩信息
     *
     * @param employeeec
     * @return
     */
    public Integer addEmpec(Employeeec employeeec) {
        return employeeecMapper.insertSelective(employeeec);
    }

    /**
     * 删除员工奖惩信息
     *
     * @param id
     * @return
     */
    public int deleteEmpecByEid(Integer id) {
        return employeeecMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新员工奖惩信息
     *
     * @param employeeec
     * @return
     */
    public int updateEmpec(Employeeec employeeec) {
        return employeeecMapper.updateByPrimaryKeySelective(employeeec);
    }
}
