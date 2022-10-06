package cn.sichu.hrms.mapper;

import cn.sichu.hrms.model.MsgContent;

/**
 * @author sichu
 * @date 2022/05/12
 */
public interface MsgContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MsgContent record);

    int insertSelective(MsgContent record);

    MsgContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MsgContent record);

    int updateByPrimaryKey(MsgContent record);
}