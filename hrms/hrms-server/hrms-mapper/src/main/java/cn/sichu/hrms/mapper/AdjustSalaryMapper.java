package cn.sichu.hrms.mapper;

import cn.sichu.hrms.model.AdjustSalary;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface AdjustSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);

    AdjustSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdjustSalary record);

    int updateByPrimaryKey(AdjustSalary record);
}