package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmpSalaryMapper;
import org.javaboy.vhr.model.EmpSalary;
import org.javaboy.vhr.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmpSalaryService {
    @Autowired
    EmpSalaryMapper empSalaryMapper;
    public List<EmpSalary> searchByEid(Integer eid) {
        return empSalaryMapper.selectByEid(eid);
    }


}
