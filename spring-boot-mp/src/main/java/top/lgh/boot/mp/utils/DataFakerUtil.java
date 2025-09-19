package top.lgh.boot.mp.utils;

import jakarta.annotation.Resource;
import net.datafaker.Faker;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import top.lgh.boot.mp.entity.UserAccount;
import top.lgh.boot.mp.service.UserAccountService;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

@Component
public class DataFakerUtil {

    private static final Faker ZH_FAKER = new Faker(Locale.CHINA);
    private static final Faker EN_FAKER = new Faker(Locale.ENGLISH);
    private static final String RAW_PASSWORD = "123456";
    private static final String ENCODED_PASSWORD = new BCryptPasswordEncoder().encode(RAW_PASSWORD);

    @Resource
    private UserAccountService userAccountService;

    private UserAccount generateOne(int i) {
        UserAccount user = new UserAccount();
        String username = EN_FAKER.internet().username();
        user.setUsername(username);
        user.setPassword(ENCODED_PASSWORD);
        user.setNickname(ZH_FAKER.name().fullName());
        user.setEmail(username + "@example.com");
        user.setPhone(ZH_FAKER.phoneNumber().cellPhone());
        user.setAvatarUrl(EN_FAKER.avatar().image()); // Changed to EN_FAKER for avatar URL consistency with username
        user.setStatus(1);
        user.setDeleted(0);
        user.setVersion(0);
        return user;
    }

    public void generateBatch() {
        int total = 1000;
        int step = 100;
        for (int start = 0; start < total; start += step) {
            List<UserAccount> batch = IntStream.range(start, start + step)
                    .mapToObj(this::generateOne)
                    .toList();
            userAccountService.saveBatch(batch, 1000);
        }
    }
}