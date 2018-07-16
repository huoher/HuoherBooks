package top.qiuchi.huoher.controller;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.qiuchi.huoher.entity.Order;
import top.qiuchi.huoher.entity.User;
import top.qiuchi.huoher.service.BookService;
import top.qiuchi.huoher.service.OrderService;
import top.qiuchi.huoher.service.WriterService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    @GetMapping("/orderlist")
    public String orderlist(Model model) {
        var orders = orderService.queryOrder();
        model.addAttribute("orders", orders);
        return "orderlist";
    }

    @GetMapping("/buybook/{bookid}")
    public String buy(@PathVariable("bookid") Integer bookid, HttpSession session) {
        var order = new Order();
        var userid = session.getAttribute("loginuserid");
        System.out.println("buybook :" + userid);
        System.out.println("buybook :" + bookid);
        order.setUserid((Integer) userid);
        order.setBookid(bookid);

        orderService.addOrder(order);
        return "redirect:/booklist";
    }

    @GetMapping("/getorder")
    public String findOrderUser(Model model, HttpSession session) {
        var loginuserid = session.getAttribute("loginuserid");
        var list = orderService.findOrderByUser((Integer) loginuserid);
        var booknamelist = new ArrayList<String>();
        for (Order order : list) {
            var book = bookService.getBookById(order.getBookid());
            var bookname = book.getBookname();
            booknamelist.add(bookname);
        }

        System.out.println("------Order Controller----");
        System.out.println("loginuserid :" + loginuserid);
        model.addAttribute("orders", list);
        model.addAttribute("books",booknamelist);
        return "orderlist";
    }

    @GetMapping("/cleanorder")
    public String cleanOrder(HttpSession session) {
        var userid = session.getAttribute("loginuserid");
        var user = new User();
        user.setUserid((Integer) userid);
        orderService.cleanOrder(user);
        return "redirect:/getorder";
    }
}
