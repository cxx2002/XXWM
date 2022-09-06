package com.cxx.reggie.controller;

import com.cxx.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 陈喜喜
 * @date 2022-08-21 22:22
 * <p>
 * 文件上传和下载
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${upload.filePath}")
    private String filePath;

    /**
     * 文件上传
     *
     * @param file 参数名需要与前端保持一致  或者用@requestPart注解
     * @return fileName
     */
    @PostMapping("/upload")
    public R<String> upload(@RequestPart("file") MultipartFile file) {
        //原始文件名   截取文件后缀名
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用UUID重新命名文件名，防止文件名重复造成文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;

        File dir = new File(filePath);
        if (!dir.exists()) dir.mkdirs();

        try {
            file.transferTo(new File(filePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }

    /**
     * 文件下载
     *
     * @param fileName 文件名  要和前端保持一致
     * @param response 响应对象
     */
    @GetMapping("/download")
    public void downLoad(@RequestParam("name") String fileName, HttpServletResponse response) {
        try {
            //输入流，输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(filePath + fileName);
            //输出流，通过输出流将文件内容写回浏览器，在浏览器展示图片
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("image/jpeg");
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
            outputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
