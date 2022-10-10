package team.seven.endless.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import team.seven.endless.api.CommonResult;
import team.seven.endless.dto.*;
import team.seven.endless.entity.ElUser;
import team.seven.endless.service.ElUserService;
import team.seven.endless.vo.ElUserLoginVo;
import team.seven.endless.vo.ElUserRegisterVo;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  用户
 * @author ben
 * @version 1.0
 * @date 2022/10/2 16:05
 */
@RestController
@RequestMapping("/el_user")
public class ElUserController {
    @Autowired
    ElUserService elUserService;

    /**
     * 得到所有用户信息
     *
     * @return {@link CommonResult}
     */
    @GetMapping("get_all_el_user")
   public CommonResult getAllElUser(){
       List<ElUser> elUserList =elUserService.getAllElUser();
       return CommonResult.success(elUserList);
   }


    /**
     * 登录页面 该API响应体中带有验证码图片
     *
     * @param response
     * @return {@link CommonResult}
     */
    @PostMapping("/login_page")
    public CommonResult loginPage(HttpServletResponse response){
        String uuid = elUserService.getLoginCaptcha(response);
        Map map = new HashMap();
        map.put("LoginCaptchaUuid",uuid);
        return CommonResult.success(map);
    }

    /**
     * 登录
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/login")
    public CommonResult login(ElUserLoginVo param){
        int result = elUserService.login(param);
        String msg = "";
        if(result==0){
            msg = "账号或密码不能为空";
            return CommonResult.failed(msg);
        }
        if(result==1){
            msg="登录成功！";
            return CommonResult.success(null,msg);
        }
        msg="账号或密码错误";
        return CommonResult.failed(msg);
    }

    /**
     * 注册
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/register")
    public CommonResult register(ElUserRegisterVo param){
        int result = elUserService.register(param);
        if(result > 0){
            return CommonResult.success(null,"注册成功");
        }
        return CommonResult.failed("注册失败");
    }

    /**
     * 更新密码
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/password")
    public CommonResult updatePassword(UpdateElUserPasswordParam param){
        if(elUserService.updatePassword(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新昵称
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/nickname")
    public CommonResult updateNickname(UpdateElUserNicknameParam param){
        if(elUserService.updateNickname(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新电子邮件
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/email")
    public CommonResult updateEmail(UpdateElUserEmailParam param){
        if(elUserService.updateEmail(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新用户角色
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/user_role")
    public CommonResult updateUserRole(UpdateElUserRoleParam param){
        if(elUserService.updateUserRole(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新头像
     *
     * @param account 账户
     * @param avatar  《阿凡达》
     * @return {@link CommonResult}
     */
    @PostMapping("/update/avatar")
    public CommonResult updateAvatar(String account, MultipartFile avatar){
        if(elUserService.updateAvatar(account,avatar)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新性别
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/sex")
    public CommonResult updateSex(UpdateElUserSexParam param){
        if(elUserService.updateSex(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新生日
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/birthday")
    public CommonResult updateBirthday(UpdateElUserBirthdayParam param){
        if(elUserService.updateBirthday(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新个性签名
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/persign")
    public CommonResult updatePerSign(UpdateElUserPerSignParam param){
        if(elUserService.updatePerSign(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新经验
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/exp")
    public CommonResult updateExp(UpdateElUserExpParam param){
        if(elUserService.updateExp(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新电话号码
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/telphone")
    public CommonResult updateTelPhone(UpdateElUserTelPhoneParam param){
        if(elUserService.updateTelPhone(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    /**
     * 更新用户状态
     *
     * @param param 参数
     * @return {@link CommonResult}
     */
    @PostMapping("/update/user_state")
    public CommonResult updateUserState(UpdateElUserStateParam param){
        if(elUserService.updateUserState(param)>0){
            return CommonResult.success(null,"修改成功");
        }
        return CommonResult.failed("修改失败");
    }


}
