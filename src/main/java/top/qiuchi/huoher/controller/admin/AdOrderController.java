package top.qiuchi.huoher.controller.admin;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.qiuchi.huoher.entity.Order;
import top.qiuchi.huoher.service.OrderService;

@Controller
public class AdOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/ad/orderlist")
    public String orderlist(Model model) {
        var orders = orderService.queryOrder();
        model.addAttribute("orders", orders);
        return "admin/orderlist";
    }

    @GetMapping("/ad/delorder/{orderid}")
    public String delorder(@PathVariable("orderid") Integer orderid){
        var order = new Order();
        order.setOrderid(orderid);
        orderService.deloneOrder(order);
        return "redirect:/ad/orderlist";
    }
}
