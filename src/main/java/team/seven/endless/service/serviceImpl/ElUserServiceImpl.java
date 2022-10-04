package team.seven.endless.service.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.seven.endless.dto.UpdateUserPasswordParam;
import team.seven.endless.entity.ElUser;
import team.seven.endless.entity.ElUserExample;
import team.seven.endless.mapper.ElUserMapper;
import team.seven.endless.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import cn.hutool.core.util.StrUtil;
/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/2 15:23
 */
@Service
@Transactional
public class ElUserServiceImpl implements UserService {
    @Autowired
    private ElUserMapper elUserMapper;

    @Override
    public List<ElUser> getAll() {
        ElUserExample elUserExample = new ElUserExample();
        return elUserMapper.selectByExample(elUserExample);
    }

    @Override
    public List<ElUser> getAllElUser() {
        ElUserExample elUserExample = new ElUserExample();
        ElUserExample.Criteria criteria = elUserExample.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        return elUserMapper.selectByExample(elUserExample);
    }

    @Override
    public ElUser getById(Long id) {
        return elUserMapper.selectByPrimaryKey(id);
    }

   @Override
   public List<ElUser> getByAccount(String account){
       ElUserExample elUserExample = new ElUserExample();
       ElUserExample.Criteria criteria = elUserExample.createCriteria();
       criteria.andAccountEqualTo(account);
       return elUserMapper.selectByExample(elUserExample);
   }

    @Override
    public int add(ElUser elUser) {
       return elUserMapper.insertSelective(elUser);
    }


    @Override
    public int update(ElUser elUser) {
       return  elUserMapper.updateByPrimaryKeySelective(elUser);
    }

    @Override
    public int updatePassword(UpdateUserPasswordParam param){
        if (StrUtil.isEmpty(param.getAccount())
                || StrUtil.isEmpty(param.getOldPassword())
                || StrUtil.isEmpty(param.getNewPassword())) {
            //属性为空
            return -1;
        }
        ElUserExample example = new ElUserExample();
        example.createCriteria().andAccountEqualTo(param.getAccount());
        List<ElUser> userList = elUserMapper.selectByExample(example);
        if (CollUtil.isEmpty(userList)) {
            //无该用户
            return -2;
        }

        ElUser elUser = userList.get(0);
        if (!Objects.equals(Arrays.toString(DigestUtil.md5(param.getNewPassword())), elUser.getPassword())) {
            //旧密码错误
            return -3;
        }
        elUser.setPassword(Arrays.toString(DigestUtil.md5(param.getNewPassword())));
        elUserMapper.updateByPrimaryKey(elUser);
//        getCacheService().delAdmin(user.getId());
        return 1;
    }

    @Override
    public int delete(String account) {
        ElUserExample example = new ElUserExample();
        example.createCriteria().andAccountEqualTo(account);
        ElUser elUser = new ElUser();
        elUser.setIsDeleted(true);
        return elUserMapper.updateByExampleSelective(elUser,example);
    }
}
