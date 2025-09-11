package top.lgh.boot.config.model;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class TeamTest {

    @Resource
    private Team team;

    @Test
    void testTeam(){
        log.info("team:{}", team);
        if (team.getAge()>5 || team.getAge()<1){
            log.error("年龄不符合要求");
        }
    }

    @Test
   void testTeam2(){
      assertEquals("ljl",team.getLeader());

   }
}