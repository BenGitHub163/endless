package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElWork;
import team.seven.endless.entity.ElWorkExample;

public interface ElWorkMapper {
    long countByExample(ElWorkExample example);

    int deleteByExample(ElWorkExample example);

    int deleteByPrimaryKey(Long workId);

    int insert(ElWork record);

    int insertSelective(ElWork record);

    List<ElWork> selectByExample(ElWorkExample example);

    ElWork selectByPrimaryKey(Long workId);

    int updateByExampleSelective(@Param("record") ElWork record, @Param("example") ElWorkExample example);

    int updateByExample(@Param("record") ElWork record, @Param("example") ElWorkExample example);

    int updateByPrimaryKeySelective(ElWork record);

    int updateByPrimaryKey(ElWork record);
}