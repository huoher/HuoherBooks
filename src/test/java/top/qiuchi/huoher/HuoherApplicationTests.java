package top.qiuchi.huoher;

import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.qiuchi.huoher.entity.User;
import top.qiuchi.huoher.mapper.UserMapper;
import top.qiuchi.huoher.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuoherApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        var user = new User();
        user.setUsername("jing");
        user.setPassword("jing");
        userService.registerUser(user);
    }

}
