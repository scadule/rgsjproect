package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.AdjustSalaryMapper;
import org.javaboy.vhr.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdjustSalaryService {
    @Autowired
    AdjustSalaryMapper adjustSalaryMapper;
    public List<AdjustSalary> getAllAdjustSalaries() {
        return adjustSalaryMapper.getAllAdjustSalaries();
    }

    public RespPageBean getAdjustSalaryByPage(Integer page, Integer size, AdjustSalary adjustSalary, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<AdjustSalary> data = adjustSalaryMapper.getAdjustSalaryByPage(page, size, adjustSalary, beginDateScope);
        Long total = adjustSalaryMapper.getTotal(adjustSalary, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }
    /**添加
     */
    public Integer addAdjustSalary(AdjustSalary adjustSalary) {
        return adjustSalaryMapper.insert(adjustSalary);
    }
    /**删除
     */
    public int deleteAdjustSalaryByEid(Integer id) {
        return adjustSalaryMapper.deleteByPrimaryKey(id);
    }
    /**更新
     */
    public int updateAdjustSalary(AdjustSalary adjustSalary) {
        return adjustSalaryMapper.updateByPrimaryKeySelective(adjustSalary);
    }
}

