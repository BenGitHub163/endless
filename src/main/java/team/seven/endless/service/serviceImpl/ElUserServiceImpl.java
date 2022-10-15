package team.seven.endless.service.serviceImpl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.seven.endless.dto.*;
import team.seven.endless.entity.ElUser;
import team.seven.endless.entity.ElUserExample;
import team.seven.endless.enums.EmailCodeEnum;
import team.seven.endless.mapper.ElUserMapper;
import team.seven.endless.service.ElUserService;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import cn.hutool.core.util.StrUtil;
import team.seven.endless.service.EmailService;
import team.seven.endless.service.RedisService;
import team.seven.endless.util.FileUtil;
import team.seven.endless.vo.ElUserLoginVo;
import team.seven.endless.vo.ElUserRegisterVo;
import team.seven.endless.vo.ElUserVo;
import team.seven.endless.vo.EmailVo;

import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/2 15:23
 */
@Service
@Transactional
public class ElUserServiceImpl implements ElUserService {
    private static final Logger LOGGER= LoggerFactory.getLogger(ElUserServiceImpl.class);

    @Autowired
    private ElUserMapper elUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RedisService redisService;

    /**
     * 得到所有用户数据
     *
     * @return {@link List}<{@link ElUser}>
     */
    @Override
    public List<ElUser> getAll() {
        ElUserExample elUserExample = new ElUserExample();
        return elUserMapper.selectByExample(elUserExample);
    }

    /**
     * 得到所有未删除用户数据
     *
     * @return {@link List}<{@link ElUser}>
     */
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

    /**
     * 根据账户获取用户数据
     *
     * @param account 账户
     * @return {@link List}<{@link ElUser}>
     */
    @Override
   public List<ElUser> getByAccount(String account){
       ElUserExample elUserExample = new ElUserExample();
       ElUserExample.Criteria criteria = elUserExample.createCriteria();
       criteria.andAccountEqualTo(account);
       return elUserMapper.selectByExample(elUserExample);
   }

   public PageInfo<ElUser> getElUserPage(int pageNum,int pageSize){
       PageHelper.startPage(pageNum,pageSize);
       List<ElUser> allElUser = getAllElUser();
       PageInfo<ElUser> pageInfo = new PageInfo<>(allElUser);
       return pageInfo;
   }

    /**
     * 添加用户
     *
     * @param elUser el用户
     * @return int
     */
    @Override
    public int add(ElUser elUser) {
       return elUserMapper.insertSelective(elUser);
    }


    /**
     * 添加用户
     *
     * @param elUser el用户
     * @return int
     */
    @Override
    public int update(ElUser elUser) {
       return  elUserMapper.updateByPrimaryKeySelective(elUser);
    }

    /**
     * 更新用户普通数据
     *
     * @param vo 签证官
     * @return int
     */
    @Override
    public int updateElUserCommonData(ElUserVo vo){
        ElUserExample example = new ElUserExample();
        example.createCriteria().andAccountEqualTo(vo.getAccount());
        List<ElUser> elUsers = elUserMapper.selectByExample(example);
        if(CollUtil.isEmpty(elUsers)){
            return -1;
        }
        ElUser elUser = elUsers.get(0);
        System.out.println("before:   "+elUser);

        BeanUtils.copyProperties(vo,elUser);

        System.out.println("after:   "+elUser);
        return elUserMapper.updateByPrimaryKey(elUser);
    }

    /**
     * 根据账号更新用户信息
     *
     * @param elUser el用户
     * @return int
     */
    public int updateByAccount(ElUser elUser){
        ElUserExample elUserExample = new ElUserExample();
        elUserExample.createCriteria().andAccountEqualTo(elUser.getAccount());
        return elUserMapper.updateByExampleSelective(elUser,elUserExample);
    }

    /**
     * 更新密码
     *
     * @param param 参数
     * @return int
     */
    @Override
    public int updatePassword(UpdateElUserPasswordParam param){
        if (StrUtil.isEmpty(param.getAccount())
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
        elUser.setPassword(passwordEncoder.encode(param.getNewPassword()));
        elUserMapper.updateByPrimaryKey(elUser);
        return 1;
    }

    @Override
    public int updateNickname(UpdateElUserNicknameParam param){
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
            avatarPath = FileUtil.uploadFile(avatar,"avatar");
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
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(param.getYear(),param.getMouth()-1,param.getDay());
        BeanUtils.copyProperties(param, elUser);
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

    /**
     * 登录
     *
     * @param param 参数
     * @return int
     */
    @Override
    public int login(ElUserLoginVo param){
        if (StrUtil.isEmpty(param.getAccount()) || StrUtil.isEmpty(param.getPassword())) {
            //账号或密码不能为空
            return 0;
        }
        ElUserExample example = new ElUserExample();
        example.createCriteria().andAccountEqualTo(param.getAccount());
        List<ElUser> elUsers = elUserMapper.selectByExample(example) ;
        if(CollUtil.isEmpty(elUsers)){
            //无效的用户名或密码
            return -1;
        }
        ElUser elUser = elUsers.get(0);
        if(passwordEncoder.matches(param.getPassword(), elUser.getPassword())){
            return 1;
        }
        //无效的用户名或密码
        return -2;
    }

    /**
     * 注册
     *
     * @param param 参数
     * @return int
     */
    @Override
    public int register(ElUserRegisterVo param){
        ElUser elUser = new ElUser();
        if(!CollUtil.isEmpty(getByAccount(param.getAccount()))){
           //账号不合法或不可用
            return -1;
        }
        String redisKey = EmailCodeEnum.VERIFICATION_CODE.getKey() + param.getEMail();

        Object redisValue = redisService.get(redisKey);
        if(null==redisValue||!Objects.equals(redisValue.toString(), param.getCaptcha())){
            //验证码有误
            return -2;
        }

        BeanUtils.copyProperties(param,elUser);
        elUser.setPassword(passwordEncoder.encode(elUser.getPassword()));
        elUser.setAvatarUrl("D:\\IdeaProjects\\endless\\src\\main\\resources\\file\\avatar\\73cd98b7cd284b8db522b48a126bc094Snipaste_2022-08-29_12-48-40.png");
        return elUserMapper.insertSelective(elUser);
    }

    /**
     * 发送验证码
     *
     * @param eMail 电子邮件
     * @return int
     */
    @Override
    public Boolean sendRegisterCaptcha(String eMail){
        EmailVo emailVo = emailService.getVerificationCodeEmailVo(eMail);
        emailService.send(emailVo,null);
        String redisKey = EmailCodeEnum.VERIFICATION_CODE.getKey() + eMail;
        return null != redisService.get(redisKey);
    }

    @Override
    public String getLoginCaptcha(HttpServletResponse response){
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        String code = captcha.getCode();
        String uuid = IdUtil.randomUUID();
        redisService.set(uuid,code);
        try {
            captcha.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uuid;
    }

    /**
     * 忘记帐户密码
     *
     * @param account 账户
     * @return {@link String}
     */
    @Override
    public String forgetPassword(String account){
        ElUser elUser;
        ElUserExample example = new ElUserExample();
        example.createCriteria().andAccountEqualTo(account);
        List<ElUser> elUsers = elUserMapper.selectByExample(example);
        //用户存在
        if(!CollUtil.isEmpty(elUsers)){
            elUser = elUsers.get(0);
            EmailVo emailVo = emailService.getVerificationCodeEmailVo(elUser.geteMail());
            emailService.send(emailVo,null);
            return elUser.geteMail();
        }
        return "";
    }

    /**
     * 是否存在该账号
     *
     * @param account 账号
     * @return {@link Boolean}
     */
    @Override
    public Boolean haveAccount(String account){
        ElUserExample example = new ElUserExample();
        example.createCriteria().andAccountEqualTo(account);
        List<ElUser> elUsers = elUserMapper.selectByExample(example);
        if(CollUtil.isEmpty(elUsers)){
            return false;
        }
        return true;
    }
}
