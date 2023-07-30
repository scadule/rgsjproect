package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Appraise;

/**
 * @eo.api-type http
 * @eo.groupName vhr-mapper1
 * @eo.path
 */

public interface AppraiseMapper {
    /**
     * @eo.name deleteByPrimaryKey
     * @eo.url
     * @eo.method get
     * @eo.request-type formdata
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @eo.name insert
     * @eo.url
     * @eo.method get
     * @eo.request-type formdata
     * @param record
     * @return int
     */
    int insert(Appraise record);

    /**
     * @eo.name insertSelective
     * @eo.url
     * @eo.method get
     * @eo.request-type formdata
     * @param record
     * @return int
     */
    int insertSelective(Appraise record);

    /**
     * @eo.name selectByPrimaryKey
     * @eo.url
     * @eo.method get
     * @eo.request-type formdata
     * @param id
     * @return Appraise
     */
    Appraise selectByPrimaryKey(Integer id);

    /**
     * @eo.name updateByPrimaryKeySelective
     * @eo.url
     * @eo.method get
     * @eo.request-type formdata
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Appraise record);

    /**
     * @eo.name updateByPrimaryKey
     * @eo.url
     * @eo.method get
     * @eo.request-type formdata
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Appraise record);
}