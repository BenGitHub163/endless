package team.seven.endless;

import cn.hutool.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import team.seven.endless.dto.UpdateElUserExpParam;
import team.seven.endless.dto.UpdateElUserTelPhoneParam;
import team.seven.endless.entity.ElUser;
import team.seven.endless.service.serviceImpl.ElUserServiceImpl;
import team.seven.endless.util.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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
        Date birth = new Date();
        Calendar  calendar = Calendar.getInstance();
        calendar.set(2001,9-1,11);
        birth =  calendar.getTime();
        user.setBirthday(birth);
        elUserService.add(user);
        List<ElUser> a =  elUserService.getAll();
        ElUser b = a.get(0);
        System.out.println(b.toString());
    }
    @Test
    void updateExpTest(){
        UpdateElUserExpParam u = new UpdateElUserExpParam();
        u.setAccount("zbh_manager");
        u.setNumber(123);
        elUserService.updateExp(u);
    }

    @Test
    void getElUserByAccount(){
        List<ElUser> elUSers = elUserService.getByAccount("zbh_manager");
        System.out.println(elUSers.get(0).toString());
    }

    @Test
    void updateTelPhone(){
        UpdateElUserTelPhoneParam u =  new UpdateElUserTelPhoneParam();
        u.setNewTelPhone("123456");
        u.setAccount("zbh_manager");
        elUserService.updateTelPhone(u);
    }

    @Test
    void uploadTest(){
        File file = new File("C:\\Users\\ben\\Desktop\\Snipaste_2022-08-29_12-48-40.png");

        MultipartFile mulFile = null;
        try {
            mulFile = new MockMultipartFile(
                    "haha.jpg", //文件名
                    "haha.jpg", //originalName 相当于上传文件在客户机上的文件名
                    ContentType.MULTIPART.toString(), //文件类型
                    new FileInputStream(file) //文件流
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            upload.uploadFile(mulFile,"avatar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
