package team.seven.endless.service;

import org.springframework.web.multipart.MultipartFile;
import team.seven.endless.dto.*;
import team.seven.endless.entity.ElUser;
import team.seven.endless.vo.ElUserLoginVo;
import team.seven.endless.vo.ElUserRegisterVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/2 15:21
 */
public interface ElUserService {
    List<ElUser> getAll();

    List<ElUser> getAllElUser();

    ElUser getById(Long id);

    List<ElUser> getByAccount(String account);

    int add(ElUser elUser);

    int update(ElUser elUser);

    /**
     * 更新密码
     *
     * @param param 参数
     * @return int
     */
    int updatePassword(UpdateElUserPasswordParam param);

    int updateNickname(UpdateElUserNicknameParam param);

    int updateEmail(UpdateElUserEmailParam param);

    int updateUserRole(UpdateElUserRoleParam param);

    int updateAvatar(String account, MultipartFile avatar);

    int updateSex(UpdateElUserSexParam param);

    int updateBirthday(UpdateElUserBirthdayParam param);

    int updatePerSign(UpdateElUserPerSignParam param);

    int updateExp(UpdateElUserExpParam param);

    int updateTelPhone(UpdateElUserTelPhoneParam param);

    int updateUserState(UpdateElUserStateParam param);

    int updateRecentLoginTimeAndIp(UpdateElUserRecentLoginTimeAndIpParam param);

    int delete(String account);

    int login(ElUserLoginVo Param);

    /**
     * 注册
     *
     * @param param 参数
     * @return int
     */
    int register(ElUserRegisterVo param);

    Boolean sendRegisterCaptcha(String eMail);

    String getLoginCaptcha(HttpServletResponse response);

    String forgetAccountPassword(String account);
}
