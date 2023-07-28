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

    public List<RespMsgBean> gettiptopDegreeNumber(){
        List<RespMsgBean> bean = employeeMapper.gettiptopDegreeNumber();
        return bean;
    }

    public List<RespMsgBean> getPositionNumber(){
        List<RespMsgBean> bean = employeeMapper.getPositionNumber();
        return bean;
    }

    public List<RespMsgBean> getnativePlaceNumber(){
        List<RespMsgBean> bean = employeeMapper.getnativePlaceNumber();
        for (RespMsgBean msg:bean) {
            if(msg.getName().equals("黑龙")){
                msg.setName("黑龙江");
            }
            else if(msg.getName().equals("内蒙")){
                msg.setName("内蒙古");
            }
        }
        for(int i = 0, len = bean.size(); i < len; i++){
            if(bean.get(i).getName().equals("1") || bean.get(i).getName().equals("")){
                bean.remove(i);
                len--;
                i--;
            }
        }
        return bean;
    }

    public List<RespMsgBean> getGenderNumber(){
        List<RespMsgBean> bean = employeeMapper.getGenderNumber();
        return bean;
    }

}
