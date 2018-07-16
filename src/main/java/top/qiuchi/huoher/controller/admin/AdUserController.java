package top.qiuchi.huoher.controller.admin;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.qiuchi.huoher.entity.User;
import top.qiuchi.huoher.service.UserService;

@Controller
public class AdUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/ad/userlist")
    public String userlist(Model model) {
        var users = userService.listuser();
        model.addAttribute("users", users);
        return "admin/userlist";
    }

    @GetMapping("/ad/deluser/{userid}")
    public String delUser(Model model,
                          @PathVariable("userid") Integer userid){
        var user = new User();
        user.setUserid(userid);
        userService.delUser(user);
        System.out.println("userService. +" + user);
        return "redirect:/ad/userlist";
    }
}
