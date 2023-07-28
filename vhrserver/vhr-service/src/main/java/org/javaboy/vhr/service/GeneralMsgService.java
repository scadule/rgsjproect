package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.RespMsgBean;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralMsgService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<RespMsgBean> getDepartmentNumber(){

        List<RespMsgBean> bean = employeeMapper.getDepartmentNumber();
        return bean;
    }

}
