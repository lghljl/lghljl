package top.lgh.boot.redis.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.lgh.boot.redis.exception.ServerException;
import top.lgh.boot.redis.result.Result;

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
