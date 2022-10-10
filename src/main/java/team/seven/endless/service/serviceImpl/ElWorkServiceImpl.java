package team.seven.endless.service.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.seven.endless.entity.ElWork;
import team.seven.endless.entity.ElWorkExample;
import team.seven.endless.mapper.ElWorkMapper;
import team.seven.endless.service.ElWorkService;
import team.seven.endless.vo.ElWorkVo;

import java.util.List;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/10 14:09
 */
@Service
@Transactional
public class ElWorkServiceImpl implements ElWorkService {

    @Autowired
    private ElWorkMapper elWorkMapper;

    /**
     * 得到所有作品
     *
     * @return {@link List}<{@link ElWork}>
     */
    @Override
    public List<ElWork> getAllElWork(){
        ElWorkExample example = new ElWorkExample();
        return elWorkMapper.selectByExample(example);
    }

    /**
     * 根据账号得到所有作品
     *
     * @return {@link List}<{@link ElWork}>
     */
    @Override
    public List<ElWork> getAllElWorkByAccount(){
        ElWorkExample example =new ElWorkExample();
        example.createCriteria().andIsDeletedEqualTo(false);
        return elWorkMapper.selectByExample(example);
    }

    /**
     * 添加
     *
     * @param elWork 作品
     * @return int
     */
    @Override
    public int add(ElWork elWork){
        return elWorkMapper.insertSelective(elWork);
    }

    /**
     * 更新
     *
     * @param elWork 作品
     * @return int
     */
    @Override
    public int update(ElWork elWork){
        ElWorkExample example = new ElWorkExample();
        example.createCriteria().andWorkIdEqualTo(elWork.getWorkId());
        List<ElWork> elWorks = elWorkMapper.selectByExample(example);
        if(!CollUtil.isEmpty(elWorks)){
            return elWorkMapper.updateByPrimaryKeySelective(elWork);
        }
        //作品不存在
        return -1;
    }

    @Override
    public int updateZanAmount(Long workId, int amount){
        ElWorkExample example = new ElWorkExample();
        example.createCriteria().andWorkIdEqualTo(workId);
        List<ElWork> elWorks = elWorkMapper.selectByExample(example);
        if(!CollUtil.isEmpty(elWorks)){
            ElWork elWork = elWorks.get(0);
            elWork.setZanAmount(amount);
            return elWorkMapper.updateByPrimaryKeySelective(elWork);
        }
        //作品不存在
        return -1;
    }

    /**
     * 更新作品普通数据
     *
     * @param vo 签证官
     * @return int
     */
    @Override
    public int updateElWorkCommonData(ElWorkVo vo){
        ElWork elWork = new ElWork();
        BeanUtils.copyProperties(vo,elWork);
        ElWorkExample example = new ElWorkExample();
        example.createCriteria().andWorkIdEqualTo(elWork.getWorkId());
        return elWorkMapper.updateByPrimaryKeySelective(elWork);
    }

    /**
     * 删除
     *
     * @param workId 工作id
     * @return int
     */
    @Override
    public int delete(Long workId){
        ElWorkExample example = new ElWorkExample();
        example.createCriteria().andWorkIdEqualTo(workId);
        List<ElWork> elWorks =elWorkMapper.selectByExample(example);
        if(CollUtil.isEmpty(elWorks)){
            //作品不存在
            return -1;
        }
        ElWork elWork = elWorks.get(0);
        return elWorkMapper.updateByPrimaryKeySelective(elWork);
    }

}
