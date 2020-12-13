package com.th.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QiniuUploadUtils {

    //设置好账号的ACCESS_KEY和SECRET_KEY;这两个登录七牛账号里面可以找到 
    static String ACCESS_KEY = "K2s3yiS3F4MKrZV83E8uylD19hDQflCichqosRbS";
    static String SECRET_KEY = "R0crtJbWqlkl_5n7KYbcOgvXW1tVn-QF-ol0bHjH";
    //要上传的空间;对应到七牛上（自己建文件夹 注意设置公开）  //http://qgbu6ffn6.hn-bkt.clouddn.com
    static String bucketname = "phonebook2020";
    //定义访问的域名
    static String yName = "http://ql1wf5w8b.hn-bkt.clouddn.com/";
    //上传到七牛后保存的文件名  
    static String key = UUID.randomUUID().toString().replace("-", "");
    //上传文件的路径 ;本地要上传文件路径  
   // String FilePath = "C:\\Users\\Administrator\\Pictures\\goodHeader\\g101301.jpg";
    //密钥配置  
    static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象,Zone.zone2()为华南地区的服务器
    static UploadManager uploadManager = new UploadManager(new Configuration(Zone.zone2()));
    //简单上传，使用默认策略，只需要设置上传的空间名就可以了  
    public static String getUpToken(){
        return auth.uploadToken(bucketname);  
    }
  
    //普通上传
    public static Map<String,Object> upload(MultipartFile myFile) throws IOException{
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            //调用put方法上传
            String newFileName = key+myFile.getOriginalFilename().substring(myFile.getOriginalFilename().lastIndexOf("."));
            Response res = uploadManager.put(myFile.getBytes(), newFileName , getUpToken());
          //  System.out.println(res.getInfo());
            //打印返回的信息
            map.put("code",200);
            map.put("newFileName",yName+newFileName);  //域名加上文件名
            map.put("msg","图片上传成功");
        } catch (QiniuException e) {  
            Response r = e.response;
            map.put("code",0);
            map.put("msg","图片上传失败");
        }
        return map;
    }  

}  
	

