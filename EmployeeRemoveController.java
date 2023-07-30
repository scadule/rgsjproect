package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.mapper.DepartmentMapper;
import org.javaboy.vhr.mapper.PositionMapper;
import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.AdjustSalaryService;
import org.javaboy.vhr.service.EmployeeRemoveService;
import org.javaboy.vhr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/emp/remove")
public class EmployeeRemoveController {
    @Autowired
    EmployeeRemoveService employeeRemoveService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    PositionMapper positionMapper;
    public List<Employeeremove> getAllEmployeeRemove() {
        List<Employeeremove> EmployeeRemoveList = employeeRemoveService.getAllEmployeeRemove();
        for(Employeeremove s:EmployeeRemoveList) {
            int id = s.getEid();
            s.setEmployee(employeeService.getEmployeeById(id));
        }

        return EmployeeRemoveList;
    }
    @GetMapping("/")
    public RespPageBean getEmployeeRemoveByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employeeremove employeeremove, Date[] beginDateScope) {
        return employeeRemoveService.getAllEmployeeRemoveByPage(page, size, employeeremove,beginDateScope);
    }
    @PostMapping("/")
    public RespBean addEmployeeRemove(@RequestBody Employeeremove employeeremove) {
        if (employeeRemoveService.addEmployeeRemove(employeeremove) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteEmployeeRemoveByEid(@PathVariable Integer id) {
        if (employeeRemoveService.deleteEmployeeRemoveByEid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
    @PutMapping("/")
    public RespBean updateEmployeeRemove(@RequestBody Employeeremove employeeremove) {
        if (employeeRemoveService.updateEmployeeRemove(employeeremove) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @GetMapping("/Position")
    public List<Position> getAllPosition(){
        return positionMapper.getAllPositions();
    }
    @GetMapping("department")
    public List<Department> getAllDepartment(){
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }
}
