package com.yalonglee.platform.controller.common;

import com.yalonglee.common.bean.LayuiUploadResult;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/8]
 * @see [相关类/方法]
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    private static final Logger logger = LogManager.getLogger(FileController.class);

    /**
     * 图片上传服务
     */
    @ApiOperation(value = "图片上传接口，返回图片地址")
    @RequestMapping(value = "/imageUpload.do")
    @ResponseBody
    public LayuiUploadResult imageUpload(MultipartFile file) {
        LayuiUploadResult layuiUploadResult = new LayuiUploadResult();
        Map<String, String> map = new HashMap<>();
        String path = "/Users/listener/Desktop/" + System.currentTimeMillis() + file.getOriginalFilename();
        map.put("url", path);
        layuiUploadResult.setCode(0);
        layuiUploadResult.setMsg("上传成功");
        layuiUploadResult.setData(map);
        File newFile = new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layuiUploadResult;
    }

    /**
     * 图片预览服务
     */
    @ApiOperation(value = "图片预览接口，返回图片")
    @RequestMapping(value = "/imageView.do")
    @ResponseBody
    public void imageView(HttpServletResponse response, String picturePath) {
        try {
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream out = null;

            synchronized (picturePath) {
                FileInputStream fis = null;
                out = new ByteArrayOutputStream();
                try {
                    fis = new FileInputStream(picturePath);
                    byte[] buffer1 = new byte[1024 * 4];
                    int n = 0;
                    while ((n = fis.read(buffer1)) != -1) {
                        out.write(buffer1, 0, n);
                    }
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                } finally {
                    try {
                        fis.close();
                        out.close();
                    } catch (IOException e) {

                    }
                }
            }
            byte[] photo = out.toByteArray();

            if (null != photo) {
                InputStream is = new ByteArrayInputStream(photo);
                while (is.read(buffer) != -1) {
                    response.getOutputStream().write(buffer);
                    response.getOutputStream().flush();
                }
            }
        } catch (IOException e) {

        }
    }


}
