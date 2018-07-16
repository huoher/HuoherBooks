package top.qiuchi.huoher.Service;

import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.qiuchi.huoher.mapper.BookMapper;
import top.qiuchi.huoher.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    @Test
    public void testGetAllAlbum(){
        bookService.getAllBook();
    }

    @Test
    public void testGetBookByWriter(){
        int writerid = 4001;
        var list = bookService.getBookByWriter(writerid);
        System.out.println(list);
    }

}
