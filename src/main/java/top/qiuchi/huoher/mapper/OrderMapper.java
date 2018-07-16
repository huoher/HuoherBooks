package top.qiuchi.huoher.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.qiuchi.huoher.entity.Order;
import top.qiuchi.huoher.entity.User;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    @Select("select * from theorder")
    public List<Order> queryOrder();

    @Select("select * from theorder where userid = #{userid}")
    public List<Order> findOrderByUser(int userid);

    @Insert("insert into theorder(userid,bookid) values (#{userid}, #{bookid})")
    public void addOrder(Order order);

    @Delete("delete from theorder where userid = #{userid} ")
    public void cleanorder(User user);

    @Delete("delete from theorder where orderid = #{orderid}")
    public void delorder(Order order);
}
