package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElUserVisitWeb;
import team.seven.endless.entity.ElUserVisitWebExample;

public interface ElUserVisitWebMapper {
    long countByExample(ElUserVisitWebExample example);

    int deleteByExample(ElUserVisitWebExample example);

    int deleteByPrimaryKey(Long userVisitWebId);

    int insert(ElUserVisitWeb record);

    int insertSelective(ElUserVisitWeb record);

    List<ElUserVisitWeb> selectByExample(ElUserVisitWebExample example);

    ElUserVisitWeb selectByPrimaryKey(Long userVisitWebId);

    int updateByExampleSelective(@Param("record") ElUserVisitWeb record, @Param("example") ElUserVisitWebExample example);

    int updateByExample(@Param("record") ElUserVisitWeb record, @Param("example") ElUserVisitWebExample example);

    int updateByPrimaryKeySelective(ElUserVisitWeb record);

    int updateByPrimaryKey(ElUserVisitWeb record);
}