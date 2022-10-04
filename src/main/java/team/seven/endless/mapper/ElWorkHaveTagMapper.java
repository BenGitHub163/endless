package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElWorkHaveTag;
import team.seven.endless.entity.ElWorkHaveTagExample;

public interface ElWorkHaveTagMapper {
    long countByExample(ElWorkHaveTagExample example);

    int deleteByExample(ElWorkHaveTagExample example);

    int deleteByPrimaryKey(Long haveId);

    int insert(ElWorkHaveTag record);

    int insertSelective(ElWorkHaveTag record);

    List<ElWorkHaveTag> selectByExample(ElWorkHaveTagExample example);

    ElWorkHaveTag selectByPrimaryKey(Long haveId);

    int updateByExampleSelective(@Param("record") ElWorkHaveTag record, @Param("example") ElWorkHaveTagExample example);

    int updateByExample(@Param("record") ElWorkHaveTag record, @Param("example") ElWorkHaveTagExample example);

    int updateByPrimaryKeySelective(ElWorkHaveTag record);

    int updateByPrimaryKey(ElWorkHaveTag record);
}