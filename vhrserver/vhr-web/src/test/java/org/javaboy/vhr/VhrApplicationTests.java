package org.javaboy.vhr;

//import org.junit.Test;
//import org.junit.runner.RunWith;

import org.javaboy.vhr.controller.emp.EmployeeecController;
import org.javaboy.vhr.controller.emp.EmployeetrainController;
import org.javaboy.vhr.controller.statistics.GeneralMsgController;
import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.RespMsgBean;
import org.javaboy.vhr.service.GeneralMsgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class VhrApplicationTests {

    @Autowired
    EmployeeecController employeeecController;

    @Autowired
    EmployeetrainController employeetrainController;

    @Autowired
    GeneralMsgController generalMsgController;

    @Test
    public void contextLoads() {
    }


    @Test
    public void getEmployeetrainByPage() {
        Employeetrain empt = new Employeetrain();
        RespPageBean bean=employeetrainController.getEmployeetrainByPage(1,10,empt,null);
        List<Employeetrain> emptrain=(List<Employeetrain>)bean.getData();
        for (Employeetrain emptrain_:emptrain) {
            System.out.println(" id:"+emptrain_.getEid()+" 培训内容："+emptrain_.getTraincontent()+" 所属部门："+emptrain_.getDepartment().getName());
            System.out.println(bean.getTotal());
        }
    }

    @Test
    public void getEmployeeecByPage() {
        Employeeec empec = new Employeeec();
        RespPageBean bean= employeeecController.getEmployeeecByPage(1, 10, empec, null);
        List<Employeeec> empecs=(List<Employeeec>)bean.getData();
        for (Employeeec empec_:empecs) {
            System.out.println(" id:"+empec_.getEid()+" 奖惩原因:"+empec_.getEcreason()+" 所属部门:"+empec_.getDepartment().getName());
        }
    }

    @Test
    public void getDepartmentNumber() {

        List<RespMsgBean> msgBeans=generalMsgController.getDepartmentNumber();
        for (RespMsgBean msg:msgBeans) {
            System.out.println(msg.getName()+" 部门人数为："+msg.getNumber());
        }
    }

}
