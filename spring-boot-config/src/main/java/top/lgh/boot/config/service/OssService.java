package top.lgh.boot.config.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    /**
     * 文件上传
     *
     * @param file 文件
     */
    String upload(MultipartFile file);
}
