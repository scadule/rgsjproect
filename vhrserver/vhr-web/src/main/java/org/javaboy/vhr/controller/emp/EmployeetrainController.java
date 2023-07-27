package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.service.EmployeetrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * {@code @负责人} 渡辺
 * {@code @功能}  员工培训控制类
 * {@code @时间} 2023-7-25 19:25
 *
 * @eo.api-type http
 * @eo.groupName EmployeentrainController
 * @eo.path /employee/train
 */
@RestController
@RequestMapping("/employee/train")
public class EmployeetrainController {

    @Autowired
    private EmployeetrainService employeetrainService;

    /**
     * @param page
     * @param size
     * @param employeetrain
     * @param beginDateScope
     * @return RespPageBean
     * @eo.name getEmployeeecByPage
     * @eo.url /
     * @eo.method get
     * @eo.request-type formdata
     */
    @GetMapping("/")
    public RespPageBean getEmployeetrainByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employeetrain employeetrain, Date[] beginDateScope) {
        return employeetrainService.getEmployeetrainByPage(page, size, employeetrain, beginDateScope);
    }

    /**
     * @param employeetrain
     * @return RespBean
     * @eo.name addEmptrain
     * @eo.url /
     * @eo.method post
     * @eo.request-type json
     */
    @PostMapping("/")
    public RespBean addEmptrain(@RequestBody Employeetrain employeetrain) {
        if (employeetrainService.addEmptrain(employeetrain) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    /**
     * @param id
     * @return RespBean
     * @eo.name deleteEmptrainByEid
     * @eo.url /{id}
     * @eo.method delete
     * @eo.request-type formdata
     */
    @DeleteMapping("/{id}")
    public RespBean deleteEmptrainByEid(@PathVariable Integer id) {
        if (employeetrainService.deleteEmptrainByEid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    /**
     * @param employeetrain
     * @return RespBean
     * @eo.name updateEmpec
     * @eo.url /
     * @eo.method put
     * @eo.request-type json
     */
    @PutMapping("/")
    public RespBean updateEmptrain(@RequestBody Employeetrain employeetrain) {
        if (employeetrainService.updateEmptrain(employeetrain) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

}
