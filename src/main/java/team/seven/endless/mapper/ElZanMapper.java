package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElZan;
import team.seven.endless.entity.ElZanExample;

public interface ElZanMapper {
    long countByExample(ElZanExample example);

    int deleteByExample(ElZanExample example);

    int deleteByPrimaryKey(Long zanId);

    int insert(ElZan record);

    int insertSelective(ElZan record);

    List<ElZan> selectByExample(ElZanExample example);

    ElZan selectByPrimaryKey(Long zanId);

    int updateByExampleSelective(@Param("record") ElZan record, @Param("example") ElZanExample example);

    int updateByExample(@Param("record") ElZan record, @Param("example") ElZanExample example);

    int updateByPrimaryKeySelective(ElZan record);

    int updateByPrimaryKey(ElZan record);
}