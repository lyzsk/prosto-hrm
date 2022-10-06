package cn.sichu.hrms.mapper;

import cn.sichu.hrms.model.Employeeec;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sichu
 * @date 2022/05/12
 */
@Mapper
public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);
}