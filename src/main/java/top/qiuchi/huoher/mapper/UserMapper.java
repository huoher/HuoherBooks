package top.qiuchi.huoher.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.qiuchi.huoher.entity.User;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> findAllUser();

    @Select("select * from user where username = #{username}")
    public User findUserByName(String username);

    @Insert("insert into user(username,password) values (#{username}, #{password})")
    public void addUser(User user);

    @Delete("delete from user where userid=#{userid}")
    public void delUser(User user);
}
