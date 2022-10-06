package cn.sichu.hrms.mapper;

import cn.sichu.hrms.model.HrRole;
import org.apache.ibatis.annotations.Param;

/**
 * @author sichu
 * @date 2022/05/12
 */
// @Mapper
public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    void deleteByHrid(Integer hrid);

    Integer addRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}