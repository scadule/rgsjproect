package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

/**
 * {@code @负责人} 渡辺
 * {@code @功能} 员工奖惩控制类
 * @时间 2023-7-25 19:25
 * @eo.api-type http
 * @eo.groupName 默认分组
 * @eo.path /employee/ec
 */
@RestController
@RequestMapping("/employee/ec")
public class EmployeeecController {

    @Autowired
    private EmployeeecService employeeecService;


    /**
     * @eo.name getEmployeeecByPage
     * @eo.url /
     * @eo.method get
     * @eo.request-type formdata
     * @param page
     * @param size
     * @param employeeec
     * @param beginDateScope
     * @return RespPageBean
     */
    @GetMapping("/")
    public RespPageBean getEmployeeecByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employeeec employeeec, Date[] beginDateScope) {
        return employeeecService.getEmployeeecByPage(page, size, employeeec, beginDateScope);
    }

    /**
     * @eo.name addEmpec
     * @eo.url /
     * @eo.method post
     * @eo.request-type json
     * @param employeeec
     * @return RespBean
     */
    @PostMapping("/")
    public RespBean addEmpec(@RequestBody Employeeec employeeec) {
        if (employeeecService.addEmpec(employeeec) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    /**
     * @eo.name deleteEmpecByEid
     * @eo.url /{id}
     * @eo.method delete
     * @eo.request-type formdata
     * @param id
     * @return RespBean
     */
    @DeleteMapping("/{id}")
    public RespBean deleteEmpecByEid(@PathVariable Integer id) {
        if (employeeecService.deleteEmpecByEid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    /**
     * @eo.name updateEmpec
     * @eo.url /
     * @eo.method put
     * @eo.request-type json
     * @param employeeec
     * @return RespBean
     */
    @PutMapping("/")
    public RespBean updateEmpec(@RequestBody Employeeec employeeec) {
        if (employeeecService.updateEmpec(employeeec) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
