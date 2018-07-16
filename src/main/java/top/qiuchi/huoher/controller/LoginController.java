package top.qiuchi.huoher.controller;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.qiuchi.huoher.entity.User;
import top.qiuchi.huoher.entity.Admin;
import top.qiuchi.huoher.service.AdminService;
import top.qiuchi.huoher.service.BookService;
import top.qiuchi.huoher.service.UserService;
import top.qiuchi.huoher.service.WriterService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private BookService bookService;

    @Autowired
    private WriterService writerService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session){
        var user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(user);
        var userid = userService.findUserid(user);
        var re = userService.Login(user);
        if (re == 1){
            System.out.println("login----------------");
            System.out.println(userid +" "+username);
            session.setAttribute("loginuser",username);
            session.setAttribute("loginuserid",userid);


            return "redirect:/index";
        }
        return "/login";
    }

    @PostMapping(value = "/admin/login")
    public String adminLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpSession session){
        var admin = new Admin();
        admin.setAdminname(username);
        admin.setAdminpassword(password);
        System.out.println("admin" + admin);
        var re = adminService.adminLogin(admin);
        if (re == 1){
            System.out.println("admin login----------------");
            session.setAttribute("loginadmin",username);
            return "redirect:/main";
        }
        return "/login";
    }
}
