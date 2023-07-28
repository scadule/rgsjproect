package org.javaboy.vhr.controller.salary;

import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.EmpSalaryService;
import org.javaboy.vhr.service.EmployeeService;
import org.javaboy.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmpSalaryService empSalaryService;
    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }


//    defaultValue：参数的默认值，如果请求中没有同名的参数时，该变量默认为此值
    public RespPageBean getAllSalariesByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Salary salary, Date[] beginDateScope) {
        return salaryService.getAllSalariesByPage(page, size, salary,beginDateScope);
    }

    /**
     * 获取所有员工账套
     */
    public List<Employee> getAllEmployeeSalary() {
        List<Employee> EmployeeList = employeeService.getAllEmployee();
        for (Employee e:EmployeeList){
            int eid = e.getId();
            List<EmpSalary> EmpSalaryList = empSalaryService.searchByEid(eid);
            for(EmpSalary em:EmpSalaryList){
                int id = em.getSid();
                e.setSalary(salaryService.selectById(id));
            }
        }
        return EmployeeList;
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalaryById(@PathVariable Integer id) {
        if (salaryService.deleteSalaryById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateSalaryById(@RequestBody Salary salary) {
        if (salaryService.updateSalaryById(salary) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}