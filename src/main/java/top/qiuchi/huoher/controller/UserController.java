package top.qiuchi.huoher.controller;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.qiuchi.huoher.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userlist")
    public String userlist(Model model) {
        var users = userService.listuser();
        model.addAttribute("users", users);
        return "userlist";
    }
}
