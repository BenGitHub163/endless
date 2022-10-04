package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElUser;
import team.seven.endless.entity.ElUserExample;

public interface ElUserMapper {
    long countByExample(ElUserExample example);

    int deleteByExample(ElUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(ElUser record);

    int insertSelective(ElUser record);

    List<ElUser> selectByExample(ElUserExample example);

    ElUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") ElUser record, @Param("example") ElUserExample example);

    int updateByExample(@Param("record") ElUser record, @Param("example") ElUserExample example);

    int updateByPrimaryKeySelective(ElUser record);

    int updateByPrimaryKey(ElUser record);
}