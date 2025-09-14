package top.lgh.boot.config.controller;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping
public class QrController {

    @Value ("$custom.qrcode.content")
    private String content;
    @GetMapping ("/generate")
    public ResponseEntity<byte[]>generateQrCode() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        QrCodeUtil.generate(content, 200, 200, ImgUtil.IMAGE_TYPE_PNG, out);
        byte[] bytes = out.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
    @GetMapping ("/generate/test")
    public ResponseEntity<byte[]>generateQrCode(@PathVariable String content) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        QrCodeUtil.generate(content, 200, 200, ImgUtil.IMAGE_TYPE_PNG, out);
        byte[] bytes = out.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
