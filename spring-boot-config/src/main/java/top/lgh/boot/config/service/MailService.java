package top.lgh.boot.config.service;

import enums.ResultStatus;
import org.springframework.web.multipart.MultipartFile;
import top.lgh.boot.config.model.Mail;

public interface MailService {
    /**
     * 发送简单邮件
     *
     * @param mail 邮件信息
     */
    ResultStatus sendSimpleMail(Mail mail);

    /**
     * 发送HTML邮件
     *
     * @param mail 邮件信息
     */
    ResultStatus sendHTMLMail(Mail mail);

    /**
     * 发送带附件的邮件
     *
     * @param mail 邮件信息
     */
    ResultStatus sendAttachmentsMail(Mail mail, MultipartFile[] files);
}