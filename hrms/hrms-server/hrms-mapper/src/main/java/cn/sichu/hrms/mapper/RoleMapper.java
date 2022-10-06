package cn.sichu.hrms.mapper;

import cn.sichu.hrms.model.Role;

import java.util.List;

/**
 * @author sichu
 * @date 2022/05/12
 */
// @Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getAllRoles();
}