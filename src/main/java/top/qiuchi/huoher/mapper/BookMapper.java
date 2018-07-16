package top.qiuchi.huoher.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.qiuchi.huoher.entity.Book;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {

    @Select("select * from book")
    public List<Book> queryBook();

    @Select("select * from book where writerid = #{writerid}")
    public List<Book> getBookByWriter(Integer id);

    @Insert("insert into book(bookname,writerid,bookcopyright,stocknum) values(#{bookname},#{writerid},#{bookcopyright},#{stocknum})")
    public void addBook(Book book);

    @Select("select * from book where id = #{id}")
    public Book getBookById(Integer id);

    @Update("update book set bookname=#{bookname},writerid=#{writerid},bookcopyright=#{bookcopyright},stocknum=#{stocknum}")
    public void updateBook(Book book);

    @Delete("delete from book where id=#{id}")
    public void deleteBook(Book book);
}
