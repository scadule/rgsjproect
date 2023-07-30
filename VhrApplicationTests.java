package org.javaboy.vhr;

//import org.junit.Test;
//import org.junit.runner.RunWith;

import org.javaboy.vhr.controller.ChatController;
import org.javaboy.vhr.controller.HrInfoController;
import org.javaboy.vhr.controller.emp.DataBaseController;
import org.javaboy.vhr.controller.emp.EmpBasicController;
import org.javaboy.vhr.controller.emp.EmployeeRemoveController;
import org.javaboy.vhr.controller.salary.AdjustSalaryController;
import org.javaboy.vhr.controller.salary.SalaryController;
import org.javaboy.vhr.converter.DateConverter;
import org.javaboy.vhr.mapper.DataBaseMapper;
import org.javaboy.vhr.mapper.EmployeeremoveMapper;
import org.javaboy.vhr.mapper.HrMapper;
import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.EmployeeService;
import org.javaboy.vhr.service.HrService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class VhrApplicationTests {
    @Autowired
    HrService hrService;
    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrInfoController hrInfoController;
    @Autowired
    DateConverter dateConverter;
    @Autowired
    ChatController chatController ;
    @Autowired
    EmpBasicController empBasicController;
    @Autowired
    SalaryController salaryController;
    @Autowired
    AdjustSalaryController adjustSalaryController;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRemoveController employeeRemoveController;
    @Autowired
    EmployeeremoveMapper employeeremoveMapper;
    @Autowired
    DataBaseController dataBaseController;
    @Autowired
    DataBaseMapper dataBaseMapper;
    @Test
    public void contextLoads() {
    Hr hr = (Hr) hrService.loadUserByUsername("libai");
        System.out.println(hr);
    }
    @Test
    public void test_register() {
        salaryController.getAllSalariesByPage(1,100,new Salary(),null);

        Hr hr = new Hr();
        hr.setId(1);
        hr.setName("李紫辉");
        hr.setPhone("15937032861");
        hr.setTelephone("029-82881233");
        hr.setAddress("河南商丘");
        hr.setEnabled(true);
        hr.setUsername("lizihui");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePass = encoder.encode("123456");
        System.out.println(encodePass);
        hr.setPassword(encodePass);
        hr.setUserface("http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg");
        RespBean bean = hrInfoController.registerHr(hr);
        System.out.println(bean.getMsg());
        System.out.println(hr);
    }
    @Test
    public void ser() {
//        查询除自己以外的hr信息
        List<Hr> hr = hrMapper.getAllHrsExceptCurrentHr(1);
//        List<Hr> a = chatController.getAllHrs();
        for (Hr a : hr){
            System.out.println(a.getId());
        }
        System.out.println(hr);

    }
    @Test
    public void Date() {
      Date a = dateConverter.convert("2023-2-5");
        System.out.println(a);
    }
    @Test
    public void test1(){

    }
    /**
     *
     *public void test(){
     *        int a =  empBasicController.getEmployeeByPage(1,2,);
     *     }
     */
    @Test
    public void test(){
        RespPageBean a =  empBasicController.getEmployeeByPage(1,100,new Employee(),null);
        System.out.println(a.getData());

    }
    /**
     * 奖惩制度
     */
    @Test
    public void reward(){
        Employeeec employeeec = employeeService.searchReward(1);

        System.out.println(employeeec.getId());

    }
    /**
     * 调薪制度
     */
    @Test
    public void changeSalary(){
        List<AdjustSalary> AdjustSalaryList = adjustSalaryController.getAllChangeSalaries();
        for(AdjustSalary s:AdjustSalaryList) {
            System.out.println(s.getRemark());
            System.out.println(s.getEmployee());
            System.out.println(s.getEmployee().getName());
        }
        AdjustSalary adjustSalary = new AdjustSalary() ;
        adjustSalary.setId(1);
        adjustSalary.setEid(2);
        adjustSalary.setAsdate(new Date());
        adjustSalary.setBeforesalary(1000);
        adjustSalary.setAftersalary(1100);
        adjustSalary.setReason("sfs");
        adjustSalary.setRemark("asaddfsaa");
//        adjustSalaryController.addAdjustSalary(adjustSalary);
//        adjustSalaryController.updateAdjustSalary(adjustSalary);
        adjustSalaryController.deleteAdjustSalaryByEid(1);

    }
    /**
     * 调动员工
     */
    @Test
    public void changeSlary(){
        List<Employeeremove> EmployeeRemoveList = employeeRemoveController.getAllEmployeeRemove();
        for(Employeeremove s:EmployeeRemoveList) {
            System.out.println(s.getEid());
            System.out.println(s.getRemark());
            System.out.println(s.getRemovedate());
            System.out.println(s.getEmployee().getName());
            System.out.println(s.getDepartment());
        }
    }

    /**
     * 测试分页
     */
    @Test
    public void test6(){
        RespPageBean a = empBasicController.getEmployeeByPage(1,2,new Employee(),null);
        System.out.println(a.getTotal());
        System.out.println();
        System.out.println(a.getData().getClass().getTypeName());
        for (Employee e:(List<Employee>)a.getData()){
            System.out.println(e.getName());
        }



    }


    /**
     * 调薪制度(分页)
     */
    @Test
    public void test2(){
       RespPageBean a = adjustSalaryController.getAdjustSalaryByPage(1,2,new AdjustSalary(),null);
        System.out.println(a.getTotal());
        System.out.println(a.getData().getClass().getTypeName());
        for (AdjustSalary e:(List<AdjustSalary>)a.getData()){
            System.out.println(e.getId());
            System.out.println(e.getEmployee());
            System.out.println(e.getRemark());
        }
    }
    /**
     * 调动员工(分页)
     */
    @Test
    public void test3(){
        RespPageBean a = employeeRemoveController.getEmployeeRemoveByPage(1,10,new
                Employeeremove(),null);
        System.out.println(a.getTotal());
        System.out.println(a.getData().getClass().getTypeName());
        for (Employeeremove e : (List<Employeeremove>)a.getData()){
            System.out.println(e.getId());
            System.out.println(e.getRemark());
            System.out.println(e.getDepartment().getName());
            System.out.println("suo"+e.getPosition().getName());
        }
        Employeeremove employeeremove = new Employeeremove();
        employeeremove.setId(5);
        employeeremove.setEid(1);
        employeeremove.setAfterdepid(1);
        employeeremove.setAfterjobid(1);
        employeeremove.setReason("fasfdsfdsafd");
        employeeremove.setRemark("sfafsafd");
//        employeeRemoveController.addEmployeeRemove(employeeremove);
//        employeeRemoveController.updateEmployeeRemove(employeeremove);
//        employeeRemoveController.deleteEmployeeRemoveByEid(5);
    }


    /**
     * 工资账套管理
     */
    @Test
    public void test4(){
        /**
         * 查找
         */
        List<Salary> SalaryList = salaryController.getAllSalaries();
        for (Salary s : SalaryList){
            System.out.println(s);
        }
        /**
         * 添加
         */
        Salary s = new Salary();
        s.setId(1);
        s.setBonus(10000);
        s.setLunchSalary(200);
        s.setTrafficSalary(100);
        s.setAllSalary(13000);
        s.setPensionBase(2000);
        s.setPensionPer((float) 0.09);
//        Date date = new Date();
//        String string = "2022-10-24";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        date = dateFormat.parse(string);
//        s.setCreateDate(date);
        s.setMedicalBase(2000);
        s.setMedicalPer((float) 0.09);
        s.setAccumulationFundBase(2000);
        s.setAccumulationFundPer((float) 0.1);
        s.setName("开发部工资账目");
        RespBean a = salaryController.addSalary(s);
        System.out.println(a.getStatus());
        System.out.println(a.getObj());
    }
    /**
     * 获取所有员工账套
     */
    @Test
    public void test5(){
        List<Employee> EmployeeList = salaryController.getAllEmployeeSalary();
        System.out.println(EmployeeList.size());
        for(Employee e:EmployeeList){
            System.out.println(e.getId());
            System.out.println(e.getName());
            try{
                System.out.println(e.getSalary().toString());
            }catch (Exception exception){
                System.out.println("此对象未选择员工账套");
            }

        }

    }

    /**
     * 获取所有员工账套(分页)缺xml
     */
    @Test
    public void test7() {
        List<Employee> EmployeeList = salaryController.getAllEmployeeSalary();
        System.out.println(EmployeeList.size());
        for(Employee e:EmployeeList){
            System.out.println(e.getId());
            System.out.println(e.getName());
            try{
                System.out.println(e.getSalary().toString());
            }catch (Exception exception){
                System.out.println("此对象未选择员工账套");
            }
        }
    }

    /**
     * 备份
     */
    @Test
    public void test8(){
        int a = dataBaseMapper.maxWorkID();
//        int i = dataBaseController.BackupEmployee();
        System.out.println(a);
//        System.out.println(i);

    }


}
