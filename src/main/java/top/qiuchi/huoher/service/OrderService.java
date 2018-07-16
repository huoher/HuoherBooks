package top.qiuchi.huoher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qiuchi.huoher.entity.Order;
import top.qiuchi.huoher.entity.User;
import top.qiuchi.huoher.mapper.OrderMapper;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public void addOrder(Order order){
        orderMapper.addOrder(order);
    }

    public void cleanOrder(User user){
        orderMapper.cleanorder(user);
    }

    public List<Order> queryOrder(){
        return orderMapper.queryOrder();
    }

    public List<Order> findOrderByUser(int userid){
        return orderMapper.findOrderByUser(userid);
    }

    public void deloneOrder(Order order){
        orderMapper.delorder(order);
    }
}
