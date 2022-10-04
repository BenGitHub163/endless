package team.seven.endless.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.seven.endless.entity.ElBrowse;
import team.seven.endless.entity.ElBrowseExample;

public interface ElBrowseMapper {
    long countByExample(ElBrowseExample example);

    int deleteByExample(ElBrowseExample example);

    int deleteByPrimaryKey(Long browseId);

    int insert(ElBrowse record);

    int insertSelective(ElBrowse record);

    List<ElBrowse> selectByExample(ElBrowseExample example);

    ElBrowse selectByPrimaryKey(Long browseId);

    int updateByExampleSelective(@Param("record") ElBrowse record, @Param("example") ElBrowseExample example);

    int updateByExample(@Param("record") ElBrowse record, @Param("example") ElBrowseExample example);

    int updateByPrimaryKeySelective(ElBrowse record);

    int updateByPrimaryKey(ElBrowse record);
}