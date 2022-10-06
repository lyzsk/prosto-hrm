package cn.sichu.hrms.mapper;

import cn.sichu.hrms.model.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sichu
 * @date 2022/05/12
 */
// @Mapper
public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPositions();

    Integer deletePositionsByIds(@Param("ids") Integer[] ids);
}