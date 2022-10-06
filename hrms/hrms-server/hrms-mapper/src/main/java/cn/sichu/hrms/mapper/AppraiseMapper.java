package cn.sichu.hrms.mapper;

import cn.sichu.hrms.model.Appraise;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@Mapper
public interface AppraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);
}