package top.lgh.boot.exception.service;

import org.springframework.stereotype.Service;
import top.lgh.boot.exception.exception.ServerException;
import top.lgh.boot.exception.enums.ErrorCode;

@Service
public class TestService {
    public void method1() {

        throw new ServerException("余额不足");
    }

    public void method2() {

        throw new ServerException(ErrorCode.FORBIDDEN);
    }

}
