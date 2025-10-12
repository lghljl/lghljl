package top.lgh.boot.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.lgh.boot.exception.common.Result;
import top.lgh.boot.exception.exception.ServerException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServerException.class)
    public Result<String> handleServerException(ServerException e) {
        return Result.error(e.getCode (),e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result<String>handleException(Exception e) {
        return Result.error(e.getMessage());
    }
}
