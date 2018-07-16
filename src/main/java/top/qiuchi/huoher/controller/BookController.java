package top.qiuchi.huoher.controller;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.qiuchi.huoher.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/booklist")
    public String booklist(Model model) {
        var list = bookService.getAllBook();
        var size = list.size();
        model.addAttribute("books", list);
        model.addAttribute("size",size);
        return "booklist";
    }

    @GetMapping("getbookbywriter/{writerid}")
    public String getboobywriter(@PathVariable("writerid") Integer writerid,
                                 Model model) {
        var list = bookService.getBookByWriter(writerid);
        model.addAttribute("books", list);
        return "booklist";
    }
}
