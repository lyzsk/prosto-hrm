package cn.sichu.hrms.mapper;

import cn.sichu.hrms.model.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sichu
 * @date 2022/05/12
 */
@Mapper
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();
}