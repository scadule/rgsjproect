package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.AdjustSalary;

/**
 * @eo.api-type http
 * @eo.groupName vhr-mapper
 * @eo.path 11
 */

public interface AdjustSalaryMapper {
    /**
     * @eo.name deleteByPrimaryKey
     * @eo.url 1
     * @eo.method get
     * @eo.request-type formdata
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @eo.name insert
     * @eo.url 2
     * @eo.method get
     * @eo.request-type formdata
     * @param record
     * @return int
     */
    int insert(AdjustSalary record);

    /**
     * @eo.name insertSelective
     * @eo.url 3
     * @eo.method get
     * @eo.request-type formdata
     * @param record
     * @return int
     */
    int insertSelective(AdjustSalary record);

    /**
     * @eo.name selectByPrimaryKey
     * @eo.url 4
     * @eo.method get
     * @eo.request-type formdata
     * @param id
     * @return AdjustSalary
     */
    AdjustSalary selectByPrimaryKey(Integer id);

    /**
     * @eo.name updateByPrimaryKeySelective
     * @eo.url 5
     * @eo.method get
     * @eo.request-type formdata
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(AdjustSalary record);

    /**
     * @eo.name updateByPrimaryKey
     * @eo.url 6
     * @eo.method get
     * @eo.request-type formdata
     * @param record
     * @return int
     */
    int updateByPrimaryKey(AdjustSalary record);
}