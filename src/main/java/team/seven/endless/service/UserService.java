package team.seven.endless.service;

import team.seven.endless.dto.UpdateUserPasswordParam;
import team.seven.endless.entity.ElUser;

import java.util.List;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/2 15:21
 */
public interface UserService {
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
    int updatePassword(UpdateUserPasswordParam param);

    int delete(String account);
}
