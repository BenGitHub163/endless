package team.seven.endless.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.seven.endless.api.CommonResult;
import team.seven.endless.entity.ElUser;
import team.seven.endless.service.ElUserService;
import team.seven.endless.vo.ElUserLoginVo;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/2 16:05
 */
@RestController
@RequestMapping("/el_user")
public class ElUserController {
    @Autowired
    ElUserService elUserService;

    @GetMapping("get_all_el_user")
   public CommonResult getAllElUser(){
       List<ElUser> elUserList =elUserService.getAllElUser();
       return CommonResult.success(elUserList);
   }


    /**
     * 登录页面
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


}
