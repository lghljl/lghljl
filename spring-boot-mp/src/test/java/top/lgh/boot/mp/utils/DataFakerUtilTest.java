package top.lgh.boot.mp.utils;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DataFakerUtilTest {

    @Resource // 使用 @Resource 注解来注入 DataFakerUtil 的实例
    private DataFakerUtil dataFakerUtil;

    @Test // 标记这是一个测试方法
    public void generateData() {
        // 调用 DataFakerUtil 类的 generateBatch() 方法
        dataFakerUtil.generateBatch();
    }
}