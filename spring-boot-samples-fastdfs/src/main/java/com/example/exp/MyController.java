package com.example.exp;/**
 * Created by HUXU on 2017/9/16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上传图片
 *
 * @author huxu
 * @create 2017-09-16 18:05
 **/
@Controller
public class MyController {

    @Autowired
    private FastDFSClientWrapper dfsClient;

    //跳转到上传文件的页面
    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    // 上传图片
    @RequestMapping(value = "/testuploadimg", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 省略业务逻辑代码。。。
        String imgUrl = dfsClient.uploadFile(file);
        // 。。。。
        return "uploadimg success:   " + imgUrl;
    }

    //删除图片
    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("url") String url) {
        dfsClient.deleteFile(url);
        return "delete success";
    }

}
