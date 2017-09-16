package com.example.demo;/**
 * Created by HUXU on 2017/9/16.
 */

import com.github.tobato.fastdfs.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;

/**
 * FastDFS文件上传下载包装类
 *
 * @author huxu
 * @create 2017-09-16 17:39
 *
 * 客户端主要包括以下接口：
    TrackerClient - TrackerServer接口
    GenerateStorageClient - 一般文件存储接口 (StorageServer接口)
    FastFileStorageClient - 为方便项目开发集成的简单接口(StorageServer接口)
    AppendFileStorageClient - 支持文件续传操作的接口 (StorageServer接口)
 **/
@Component
public class FastDFSClientWrapper {

    private final Logger logger = LoggerFactory.getLogger(FastDFSClientWrapper.class);

    @Autowired
    private FastFileStorageClient storageClient;

   /* @Autowired
    private AppConfig appConfig;   // 项目参数配置*/

    @Autowired
    private FdfsWebServer fdfsWebServer;

    /**
     * 上传文件
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath);
    }

    /**
     * 将一段字符串生成一个文件上传
     * @param content 文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream,buff.length, fileExtension,null);
        return getResAccessUrl(storePath);
    }

    // 封装图片完整URL地址
    private String getResAccessUrl(StorePath storePath) {
        /*String fileUrl = AppConstants.HTTP_PRODOCOL + appConfig.getResHost()
                + ":" + appConfig.getFdfsStoragePort() + "/" + storePath.getFullPath();
        return fileUrl;*/
        String fileUrl = fdfsWebServer.getWebServerUrl() + storePath.getFullPath();
        return fileUrl;
    }

    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            logger.warn(e.getMessage());
        }
    }

    /**
     * 传图片并同时生成一个缩略图
     * "JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP"
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public StorePath uploadImageAndCrtThumbImage(MultipartFile file) throws IOException{
        StorePath storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(),file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return storePath;
    }



}
