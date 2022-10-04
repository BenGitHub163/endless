package team.seven.endless;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.seven.endless.entity.ElUser;
import team.seven.endless.service.serviceImpl.ElUserServiceImpl;

import java.util.List;

@SpringBootTest
class EndlessApplicationTests {

    @Autowired
    private  ElUserServiceImpl elUserService;
    @Test
    void contextLoads() {
    }

    @Test
    void addElUser(){
        ElUser user = new ElUser();
        user.setAccount("zbh_manager");
        user.setPassword("123456");
        user.setNickname("小张");
        elUserService.add(user);
        List<ElUser> a =  elUserService.getAll();
        ElUser b = a.get(0);
        System.out.println(b.toString());
    }
    @Test
    void getUser(){

    }

}
