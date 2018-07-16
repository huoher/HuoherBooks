package top.qiuchi.huoher.service;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qiuchi.huoher.entity.Book;
import top.qiuchi.huoher.mapper.BookMapper;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBook(){
        var books = bookMapper.queryBook();
        return books;
    }

    public List<Book> getBookByWriter(Integer id){
        return bookMapper.getBookByWriter(id);
    }

    public void addBook(Book book){
        bookMapper.addBook(book);
    }

    public void delBook(Book book){
        bookMapper.deleteBook(book);
    }

    public Book getBookById(Integer id){
        return bookMapper.getBookById(id);
    }

    public void updateBook(Book book){
        bookMapper.updateBook(book);
    }
}
