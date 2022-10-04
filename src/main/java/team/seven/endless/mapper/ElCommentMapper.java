package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElComment;
import team.seven.endless.entity.ElCommentExample;

public interface ElCommentMapper {
    long countByExample(ElCommentExample example);

    int deleteByExample(ElCommentExample example);

    int deleteByPrimaryKey(Long commentId);

    int insert(ElComment record);

    int insertSelective(ElComment record);

    List<ElComment> selectByExample(ElCommentExample example);

    ElComment selectByPrimaryKey(Long commentId);

    int updateByExampleSelective(@Param("record") ElComment record, @Param("example") ElCommentExample example);

    int updateByExample(@Param("record") ElComment record, @Param("example") ElCommentExample example);

    int updateByPrimaryKeySelective(ElComment record);

    int updateByPrimaryKey(ElComment record);
}