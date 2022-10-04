package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElWorkTag;
import team.seven.endless.entity.ElWorkTagExample;

public interface ElWorkTagMapper {
    long countByExample(ElWorkTagExample example);

    int deleteByExample(ElWorkTagExample example);

    int deleteByPrimaryKey(Long workTagId);

    int insert(ElWorkTag record);

    int insertSelective(ElWorkTag record);

    List<ElWorkTag> selectByExample(ElWorkTagExample example);

    ElWorkTag selectByPrimaryKey(Long workTagId);

    int updateByExampleSelective(@Param("record") ElWorkTag record, @Param("example") ElWorkTagExample example);

    int updateByExample(@Param("record") ElWorkTag record, @Param("example") ElWorkTagExample example);

    int updateByPrimaryKeySelective(ElWorkTag record);

    int updateByPrimaryKey(ElWorkTag record);
}