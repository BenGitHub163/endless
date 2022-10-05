package team.seven.endless.service.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import team.seven.endless.dto.*;
import team.seven.endless.entity.ElUser;
import team.seven.endless.entity.ElUserExample;
import team.seven.endless.mapper.ElUserMapper;
import team.seven.endless.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import cn.hutool.core.util.StrUtil;
import team.seven.endless.util.upload;

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
    private static final Logger LOGGER= LoggerFactory.getLogger(ElUserServiceImpl.class);

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

    public int updateByAccount(ElUser elUser){
        ElUserExample elUserExample = new ElUserExample();
        elUserExample.createCriteria().andAccountEqualTo(elUser.getAccount());
        return elUserMapper.updateByExampleSelective(elUser,elUserExample);
    }

    @Override
    public int updatePassword(UpdateElUserPasswordParam param){
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
        if (!Objects.equals(Arrays.toString(DigestUtil.md5(param.getOldPassword())), elUser.getPassword())) {
            //旧密码错误
            return -3;
        }
        elUser.setPassword(Arrays.toString(DigestUtil.md5(param.getNewPassword())));
        elUserMapper.updateByPrimaryKey(elUser);
        return 1;
    }

    @Override
    public int updateNickname(UpdateUserNicknameParam param){
        ElUser elUser = new ElUser();
        elUser.setAccount(param.getAccount());
        elUser.setNickname(param.getNewNickname());
        return updateByAccount(elUser);
    }

    @Override
    public int updateEmail(UpdateElUserEmailParam param){
        ElUser elUser = new ElUser();
        elUser.setAccount(param.getAccount());
        elUser.seteMail(param.getEmail());
        return updateByAccount(elUser);
    }

    @Override
    public int updateUserRole(UpdateElUserRoleParam param){
        ElUser elUser = new ElUser();
        BeanUtils.copyProperties(param, elUser);
        return updateByAccount(elUser);
    }

    @Override
    public int updateAvatar(String account, MultipartFile avatar){
        String avatarPath = "";
        try {
            avatarPath = upload.uploadFile(avatar,"avatar");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ElUser elUser = new ElUser();
        elUser.setAccount(account);
        elUser.setAvatarUrl(avatarPath);

        return updateByAccount(elUser);
    }

    @Override
    public int updateSex(UpdateElUserSexParam param){
        ElUser elUser = new ElUser();
        BeanUtils.copyProperties(param, elUser);
        return updateByAccount(elUser);
    }

    @Override
    public int updateBirthday(UpdateElUserBirthdayParam param){
        ElUser elUser = new ElUser();
        Calendar calendar = Calendar.getInstance();
        calendar.set(param.getYear(),param.getMouth()-1,param.getDay());
        return updateByAccount(elUser);
    }

    @Override
    public int updatePerSign(UpdateElUserPerSignParam param){
        ElUser elUser = new ElUser();
        BeanUtils.copyProperties(param, elUser);
        return updateByAccount(elUser);
    }

    @Override
    public int updateExp(UpdateElUserExpParam param){
        ElUserExample elUserExample = new ElUserExample();
        elUserExample.createCriteria().andAccountEqualTo(param.getAccount());
        List<ElUser> elUsers = elUserMapper.selectByExample(elUserExample);
        if(elUsers==null|| elUsers.size()==0){
            return -1;
        }
        elUsers.get(0).setExp(elUsers.get(0).getExp()+param.getNumber());
        return elUserMapper.updateByPrimaryKey(elUsers.get(0));
    }

    @Override
    public int updateTelPhone(UpdateElUserTelPhoneParam param){
        ElUser elUser = new ElUser();
        elUser.setAccount(param.getAccount());
        elUser.setTelPhone(param.getNewTelPhone());
        return updateByAccount(elUser);
    }

    @Override
    public int updateUserState(UpdateElUserStateParam param){
        ElUser elUser = new ElUser();
        BeanUtils.copyProperties(param, elUser);
        return updateByAccount(elUser);
    }

    @Override
    public int updateRecentLoginTimeAndIp(UpdateElUserRecentLoginTimeAndIpParam param){
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
