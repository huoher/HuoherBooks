package top.qiuchi.huoher.controller.admin;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.qiuchi.huoher.entity.Book;
import top.qiuchi.huoher.service.BookService;
import top.qiuchi.huoher.service.WriterService;

@Controller
public class AdBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private WriterService writerService;

    @GetMapping("/ad/booklist")
    public String booklist(Model model) {
        var list = bookService.getAllBook();
        model.addAttribute("books", list);
        return "admin/booklist";
    }

    @PostMapping("/ad/addbook")
    public String addbook(Model model,
                          @RequestParam("bookname") String bookname,
                          @RequestParam("bookwriterid") int bookwriterid,
                          @RequestParam("bookcopyright") String bookcopyright,
                          @RequestParam("stocknum") int stocknum) {
        System.out.println("[bookname]" + bookname);
        System.out.println("[bookwriterid]" + bookwriterid);
        System.out.println("[bookcopyright]" + bookcopyright);
        System.out.println("[stocknum]" + stocknum);
        var book = new Book();
        book.setBookcopyright(bookcopyright);
        book.setBookname(bookname);
        book.setWriterid(bookwriterid);
        book.setStocknum(stocknum);

        bookService.addBook(book);
        return "redirect: /ad/booklist";
    }

    @GetMapping("/admin/addbook")
    public String addbookinfo(Model model){
        var list = writerService.getAllWriter();
        model.addAttribute("writers",list);
        return "admin/addBook";
    }

    @GetMapping("/admin/updatebook/{id}")
    public String updatebook(@PathVariable("id") Integer id, Model model){
        var book = bookService.getBookById(id);
        var list = writerService.getAllWriter();
        model.addAttribute("writers",list);
        model.addAttribute("book",book);
        return "admin/updateBook";
    }

    @PostMapping("/ad/updatebook/{id}")
    public String updatebook(Model model,
                             @RequestParam("bookname") String bookname,
                              @RequestParam("bookwriterid") int bookwriterid,
                              @RequestParam("bookcopyright") String bookcopyright,
                              @RequestParam("stocknum") int stocknum){
        var book = new Book();
        book.setBookcopyright(bookcopyright);
        book.setBookname(bookname);
        book.setWriterid(bookwriterid);
        book.setStocknum(stocknum);

        bookService.updateBook(book);
        return "redirect:/ad/booklist";
    }

    @GetMapping("/ad/delbook/{id}")
    public String delBook(@PathVariable("id") Integer id){
        var book = new Book();
        book.setId(id);
        bookService.delBook(book);
        return "redirect:/ad/booklist";
    }
}
