package team.seven.endless;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.seven.endless.entity.ElUser;
import team.seven.endless.entity.ElWork;
import team.seven.endless.service.ElUserService;
import team.seven.endless.service.ElWorkService;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/10 14:30
 */
@SpringBootTest
public class ElWorkTest {
    @Autowired
    private ElWorkService elWorkService;

    @Autowired
     private ElUserService elUserService;

    @Test
    public void addElWork(){
        ElWork elWork = new ElWork();
        ElUser u = elUserService.getByAccount("zbh_manager").get(0);
        elWork.setWorkType((byte)1);
        elWork.setUserId(u.getUserId());
        elWork.setZanAmount(12);
        elWork.setWorkTitle("我的区长父亲");
        elWorkService.add(elWork);
    }
}
