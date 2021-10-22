package com.bobo.mall.controller;

import com.bobo.mall.entity.R;
import com.bobo.mall.utils.TencentCOSUploadFileUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 对象存储上传图片
 * @Date 2021/10/19 21:08
 * @Created by bobo
 */
@RestController
@Api(value = "腾讯云对象存储controller", tags = {"腾讯云对象存储控制器"})
@RequestMapping("/mall/oss/image")
public class OssController {
    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file) {
        if (null == file) {
            return R.error();
        }
        String filePath = TencentCOSUploadFileUtil.uploadfile(file);
        return R.ok().data("url", filePath);
    }
}
