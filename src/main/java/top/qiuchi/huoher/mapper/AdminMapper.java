package top.qiuchi.huoher.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.qiuchi.huoher.entity.Admin;

@Repository
@Mapper
public interface AdminMapper {

    @Select("select * from admin where adminname = #{adminname} ")
    public Admin getadminbyname(String adminname);


}
