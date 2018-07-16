package top.qiuchi.huoher.controller.admin;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.qiuchi.huoher.entity.Writer;
import top.qiuchi.huoher.service.WriterService;

@Controller
public class AdWriterController {

    @Autowired
    private WriterService writerService;

    @GetMapping("/ad/writerlist")
    public String writerlist(Model model) {
        var list = writerService.getAllWriter();
        model.addAttribute("writers", list);
        return "admin/writerlist";
    }

    @PostMapping("/ad/addWriter")
    public String addWriter(Model model,
                            @RequestParam("writername") String writername) {
        var writer = new Writer();
        writer.setWritername(writername);
        writerService.addWriter(writer);
        return "redirect:/ad/writerlist";
    }

    @GetMapping("/admin/addWriter")
    public String addWriter(){
        return "/admin/addWriter";
    }

    @PostMapping("/ad/delWriter")
    public String delWriter(Model model,
                            @RequestParam("id") Integer id){
        var writer = new Writer();
        writer.setId(id);
        writerService.deleteWriter(writer);
        return "redirect:/ad/writerlist";
    }
}
