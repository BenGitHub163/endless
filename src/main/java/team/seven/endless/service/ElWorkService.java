package team.seven.endless.service;

import team.seven.endless.entity.ElWork;
import team.seven.endless.vo.ElWorkVo;

import java.util.List;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/8 14:30
 */
public interface ElWorkService {

    /**
     * 得到所有作品
     *
     * @return {@link List}<{@link ElWork}>
     */
    List<ElWork> getAllElWork();

    /**
     * 根据账号得到所有作品
     *
     * @return {@link List}<{@link ElWork}>
     */
    List<ElWork> getAllElWorkByAccount();

    /**
     * 添加
     *
     * @param elWork 作品
     * @return int
     */
    int add(ElWork elWork);

    /**
     * 更新
     *
     * @param elWork 埃尔工作
     * @return int
     */
    int update(ElWork elWork);

    int updateZanAmount(Long workId,int amount);

//    int updateWorkUrl();
//
//    int updateWorkTitle();
//
//    int updateWorkIntroduce();
//
//    int updateWorkCoverUrl();

    /**
     * 更新作品普通数据
     *
     * @param vo 签证官
     * @return int
     */
    int updateElWorkCommonData(ElWorkVo vo);

    /**
     * 删除
     *
     * @param workId 工作id
     * @return int
     */
    int delete(Long workId);



}
