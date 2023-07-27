package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeetrainMapper;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeetrainService {
    @Autowired
    EmployeetrainMapper employeetrainMapper;

    /**
     * 以分页的形式获取员工的奖惩信息
     *
     * @param page
     * @param size
     * @param employeetrain
     * @param beginDateScope
     * @return
     */
    public RespPageBean getEmployeetrainByPage(Integer page, Integer size, Employeetrain employeetrain, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employeetrain> data = employeetrainMapper.getEmployeetrainByPage(page, size, employeetrain, beginDateScope);
        Long total = employeetrainMapper.getTotal(employeetrain, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    /**
     * 添加员工奖惩信息
     *
     * @param employeetrain
     * @return
     */
    public Integer addEmptrain(Employeetrain employeetrain) {
        return employeetrainMapper.insertSelective(employeetrain);
    }

    /**
     * 删除员工培训信息
     *
     * @param id
     * @return
     */
    public int deleteEmptrainByEid(Integer id) {
        return employeetrainMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除更新员工培训信息
     *
     * @param employeetrain
     * @return
     */
    public int updateEmptrain(Employeetrain employeetrain) {
        return employeetrainMapper.updateByPrimaryKeySelective(employeetrain);
    }
}
