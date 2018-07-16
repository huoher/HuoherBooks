package top.qiuchi.huoher.Service;

import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.qiuchi.huoher.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrderService {

    @Autowired
    private OrderService orderService;

    @Test
    public void listorder(){
        var list = orderService.queryOrder();
        System.out.println(list);
    }
}
