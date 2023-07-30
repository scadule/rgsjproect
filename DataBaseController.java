package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.AdjustSalary;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/emp/backup")
public class DataBaseController {
    @Autowired
    DataBaseService dataBaseService;
    /**
     * 恢复
     */
    @GetMapping("/Employee")
    public int BackupEmployee(){
        return dataBaseService.BackupEmployee();
    }
    @GetMapping("/EmployeeRemove")
    public int BackupEmployeeRemove(){
        return dataBaseService.BackupEmployeeRemove();
    }
    @GetMapping("/AdjustSalary")
    public int BackupAdjustSalary(){
        return dataBaseService.BackupAdjustSalary();
    }
    @GetMapping("/Salary")
    public int BackupSalary(){
        return dataBaseService.BackupSalary();
    }

    /**
     * 备份
     */
    @GetMapping("/rEmployee")
    public int RecoverEmployee(){
        return dataBaseService.RecoverEmployee();
    }
    @GetMapping("/rEmployeeRemove")
    public int RecoverEmployeeRemove(){
        return dataBaseService.RecoverEmployeeRemove();
    }
    @GetMapping("/rAdjustSalary")
    public int RecoverAdjustSalary(){
        return dataBaseService.RecoverAdjustSalary();
    }
    @GetMapping("/rEmpSalary")
    public int RecoverEmpSalary(){
        return dataBaseService.RecoverEmpSalary();
    }

}
