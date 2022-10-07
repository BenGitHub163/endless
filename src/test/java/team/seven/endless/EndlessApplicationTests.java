package team.seven.endless;

import cn.hutool.core.util.IdUtil;
import cn.hutool.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import team.seven.endless.dto.UpdateElUserExpParam;
import team.seven.endless.dto.UpdateElUserTelPhoneParam;
import team.seven.endless.entity.ElUser;
import team.seven.endless.service.serviceImpl.ElUserServiceImpl;
import team.seven.endless.util.FileUtil;

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
    void testAddElUser(){
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
    void testUpdateExp(){
        UpdateElUserExpParam u = new UpdateElUserExpParam();
        u.setAccount("zbh_manager");
        u.setNumber(123);
        elUserService.updateExp(u);
    }

    @Test
    void testgetElUserByAccount(){
        List<ElUser> elUSers = elUserService.getByAccount("zbh_manager");
        System.out.println(elUSers.get(0).toString());
    }

    @Test
    void testupdateTelPhone(){
        UpdateElUserTelPhoneParam u =  new UpdateElUserTelPhoneParam();
        u.setNewTelPhone("123456");
        u.setAccount("zbh_manager");
        elUserService.updateTelPhone(u);
    }

    @Test
    void testupload(){
        File file = new File("C:\\Users\\ben\\Desktop\\38756ac7480c901fc144f5c2931c0e6a.mp4");

        MultipartFile mulFile = null;
        try {
            mulFile = new MockMultipartFile(
                    "38756ac7480c901fc144f5c2931c0e6a.mp4", //文件名
                    "38756ac7480c901fc144f5c2931c0e6a.mp4", //originalName 相当于上传文件在客户机上的文件名
                    ContentType.MULTIPART.toString(), //文件类型
                    new FileInputStream(file) //文件流
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileUtil.uploadFile(mulFile,"avatar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUUID(){
        System.out.println("IdUtil   "+IdUtil.simpleUUID());
    }

    @Test
    public void testUpdateAvatar(){
        String fileName = "Snipaste_2022-08-29_12-48-40.png";
        File file = new File("C:\\Users\\ben\\Desktop\\"+fileName);

        MultipartFile mulFile = null;
        try {
            mulFile = new MockMultipartFile(
                    fileName, //文件名
                    fileName, //originalName 相当于上传文件在客户机上的文件名
                    ContentType.MULTIPART.toString(), //文件类型
                    new FileInputStream(file) //文件流
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        elUserService.updateAvatar("zbh_manager",mulFile);
    }
}
