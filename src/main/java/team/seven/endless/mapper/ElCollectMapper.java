package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElCollect;
import team.seven.endless.entity.ElCollectExample;

public interface ElCollectMapper {
    long countByExample(ElCollectExample example);

    int deleteByExample(ElCollectExample example);

    int deleteByPrimaryKey(Long collectId);

    int insert(ElCollect record);

    int insertSelective(ElCollect record);

    List<ElCollect> selectByExample(ElCollectExample example);

    ElCollect selectByPrimaryKey(Long collectId);

    int updateByExampleSelective(@Param("record") ElCollect record, @Param("example") ElCollectExample example);

    int updateByExample(@Param("record") ElCollect record, @Param("example") ElCollectExample example);

    int updateByPrimaryKeySelective(ElCollect record);

    int updateByPrimaryKey(ElCollect record);
}