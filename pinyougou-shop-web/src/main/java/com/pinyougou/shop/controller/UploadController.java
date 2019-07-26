package com.pinyougou.shop.controller;

import entity.ResultMsg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.FastDFSClient;

/**
 * ClassName: UploadController <br/>
 * Description: <br/>
 * date: 2019-05-06 01:43<br/>
 *
 * @author liuzhuangzhuang<br />
 */
@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String file_server_url;

    @RequestMapping("/uploadImageFastDFS")
    public ResultMsg uploadImageFastDFS(MultipartFile file){
        //获取文件的真时路径，获取该文件后缀名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf("." )+1);

        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            String fileId = fastDFSClient.uploadFile(file.getBytes(),extName);
            String file_url = file_server_url + fileId;
            return new ResultMsg(true,file_url);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false,"上传失败");
        }

    }
}
