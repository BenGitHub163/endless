package team.seven.endless.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/5 16:27
 */
public class upload {
    private static final Logger LOGGER= LoggerFactory.getLogger(upload.class);


    /**
     * 上传文件
     *
     * @param file 文件
     * @param type 类型
     * @return {@link String}
     * @throws Exception 异常
     */
    public static String uploadFile(MultipartFile file, String type) throws Exception {
        String os = System.getProperty("os.name");
        File fileRealPath;   //文件存放地址
        if (os.toLowerCase().startsWith("win")) {  //windows系统
            String path = System.getProperty("user.dir");  //获取项目相对路径
            fileRealPath = new File(path+"/src//main/resources/file"+"/"+type);
        }else{//linux系统
            //获取根目录
            //如果是在本地windows环境下，目录为项目的target\classes下
            //如果是linux环境下，目录为jar包同级目录
            File rootPath = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!rootPath.exists()){
                rootPath = new File("");
            }
            fileRealPath = new File(rootPath.getAbsolutePath()+"/file/"+type+"/");
        }
        //判断文件夹是否存在
        if(!fileRealPath.exists()){
            //不存在，创建
            fileRealPath.mkdirs();
        }
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //创建文件存放地址
        File resultPath = new File(fileRealPath+"/"+fileName);
        if (resultPath.exists()){
            LOGGER.warn("文件已经存在！");
            return "-1";
        }
        file.transferTo(resultPath);
        System.out.println("absolutePath:"+fileRealPath.getCanonicalPath());
        System.out.println("resultPath:"+resultPath.getCanonicalPath());
        return resultPath.getPath();
    }
}
