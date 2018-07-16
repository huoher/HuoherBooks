package top.qiuchi.huoher.controller;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.qiuchi.huoher.service.WriterService;

@Controller
public class WriterController {

    @Autowired
    private WriterService writerService;

    @GetMapping("/writerlist")
    public String writerlist(Model model){
        var list = writerService.getAllWriter();
        model.addAttribute("writers",list);
        return "writerlist";
    }
}
