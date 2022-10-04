package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElFollow;
import team.seven.endless.entity.ElFollowExample;

public interface ElFollowMapper {
    long countByExample(ElFollowExample example);

    int deleteByExample(ElFollowExample example);

    int deleteByPrimaryKey(Long followId);

    int insert(ElFollow record);

    int insertSelective(ElFollow record);

    List<ElFollow> selectByExample(ElFollowExample example);

    ElFollow selectByPrimaryKey(Long followId);

    int updateByExampleSelective(@Param("record") ElFollow record, @Param("example") ElFollowExample example);

    int updateByExample(@Param("record") ElFollow record, @Param("example") ElFollowExample example);

    int updateByPrimaryKeySelective(ElFollow record);

    int updateByPrimaryKey(ElFollow record);
}